/*
   Sample execution:

$java ReviewAnalysis
ra.getAverageRating() should be 3.4: 3.4
list returned by collectComments should be 
[0-Good! Thx.| 2-Great!| 3-Poor! Bad. :
[0-Good! Thx., 2-Great!, 3-Poor! Bad.]
*/

import java.util.ArrayList;

public class ReviewAnalysis
{

    /** Returns a double representing the average rating of all the 
     * Review objects to be analyzed, as described in part (a)
     * Precondition: allReviews contains at least one Review.
     * No element of allReviews is null.
     */
    // part (a)
    public double getAverageRating()
    {
        int sum = 0;
        for(Review r : allReviews)
            sum += r.getRating();
        return (double) sum / allReviews.length;
    }
    
    /** Returns an ArrayList of String objects containing formatted 
     * versions of selected user comments, as described in part (b)
     * Precondition: allReviews contains at least one Review.
     *   No element of allReviews is null.
     * Postcondition: allReviews is unchanged.
     */
    // part (b)
    public ArrayList<String> collectComments()
    {
        ArrayList<String> list = new ArrayList<String>();

        for(int i = 0; i < allReviews.length; i++) {
            String c = allReviews[i].getComment();
            if(c.contains("!")) {
                String s = i + "-" + c;
                String l = s.substring(s.length() - 1);
                if(!(l.equals(".") || l.equals("!")))
                    s += ".";
                list.add(s);
            }
        }
        
        return list;
    }

    /* scaffolding */
    
    /** All user reviews to be included in this analysis */
    private Review[] allReviews;

    /** Initializes allReviews to contain all the Review objects 
     *  to be analyzed */
    public ReviewAnalysis()
    {
        allReviews = new Review[1];
        allReviews[0] = new Review(0, "");
    }
    
    public ReviewAnalysis(Review[] reviews)
    {
        allReviews = reviews;
    }
    

    public static void main(String[] args) {
        Review[] ar = new Review[5];
        ar[0] = new Review(4, "Good! Thx");
        ar[1] = new Review(3, "OK site");
        ar[2] = new Review(5, "Great!");
        ar[3] = new Review(2, "Poor! Bad.");
        ar[4] = new Review(3, "");
        ReviewAnalysis ra = new ReviewAnalysis(ar);
        System.out.println("ra.getAverageRating() should be 3.4: " +
                           ra.getAverageRating());

        ArrayList<String> al = ra.collectComments();
        System.out.println("list returned by collectComments should be ");
        System.out.println("[0-Good! Thx.| 2-Great!| 3-Poor! Bad. :");
        System.out.println(al);
        
    }
}
