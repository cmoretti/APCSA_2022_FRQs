/* 
   prerequisite for scaffolding:
   StdIn and StdOut libraries from Sedgewick and Wayne:
   https://introcs.cs.princeton.edu/java/stdlib/StdIn.java.html
   https://introcs.cs.princeton.edu/java/stdlib/StdOut.java.html

   Sample execution:
$echo 75 50 90 20 | java-introcs Game
Game 1 should be 2400: 2400
Game 2 should be  300: 300
Game 3 should be  600: 600
Game 3 should be    0: 0
If you enter scores 75, 50, 90, and 20, the max should be 90: 
Enter the score of this game: Enter the score of this game: Enter the score of this game: Enter the score of this game: 90

*/

public class Game
{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;

    private boolean bonus;

    // part (a)
    public int getScore()
    {
        int points = 0;
        if(levelOne.goalReached())
        {
            points += levelOne.getPoints();
            if(levelTwo.goalReached())
            {
                points += levelTwo.getPoints();
                if(levelThree.goalReached())
                    points += levelThree.getPoints();
            }
        }
        if(isBonus())
            points *= 3;
        return points;
    }

    // part (b)
    public int playManyTimes(int num)
    {
        int max = 0;
        for(int i = 0; i < num; i++)
        {
            play();
            int score = getScore();
            if(score > max)
                max = score;
        }
        return max;
    }

    // scaffolding
    
    public Game() {
        levelOne = new Level(0);
        levelTwo = new Level(0);
        levelThree = new Level(0);
        bonus = false;
    }

    public Game(int goal1, int goal2, int goal3, boolean bonus) {
        levelOne = new Level(goal1);
        levelTwo = new Level(goal2);
        levelThree = new Level(goal3);
        this.bonus = bonus;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void play() {
        StdOut.print("Enter the score of this game: ");
        levelOne.earnPoints(StdIn.readInt());
    }
    
    public void play(int score1, int score2, int score3) {
        levelOne.earnPoints(score1);
        levelTwo.earnPoints(score2);
        levelThree.earnPoints(score3);
    }
    

    public static void main(String[] args) {
        Game g = new Game(0, 0, 0, true);
        g.play(200, 100, 500);
        StdOut.println("Game 1 should be 2400: " + g.getScore());

        g = new Game(0, 0, 1000, false);
        g.play(200, 100, 500);
        StdOut.println("Game 2 should be  300: " + g.getScore());

        g = new Game(0, 1000, 0, true);
        g.play(200, 100, 500);
        StdOut.println("Game 3 should be  600: " + g.getScore());

        g = new Game(1000, 0, 0, false);
        g.play(200, 100, 500);
        StdOut.println("Game 3 should be    0: " + g.getScore());

        g = new Game();
        StdOut.println("If you enter scores 75, 50, 90, and 20, the max should be 90: ");
        StdOut.println(g.playManyTimes(4));
    }
}
