public class Level
{

    private int scoreRequired;
    private int score;
    
    /** Returns true if the player reached the goal on this level
     *  and returns false otherwise */
    public boolean goalReached()
    {
        return score >= scoreRequired;
    }


    /** Returns the number of points (a positive integer) recorded
     *  for this level */

    public int getPoints()
    {
        return score;
    }

    public Level(int goal) {
        scoreRequired = goal;
    }

    public void earnPoints(int points) {
        score = points;
    }
}
