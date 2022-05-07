public class Textbook extends Book
{

    private int edition;

    public Textbook(String bookTitle, double bookPrice, int bookEdition)
    {
        super(bookTitle, bookPrice);
        edition = bookEdition;
    }

    public String getBookInfo()
    {
        return super.getBookInfo() + "-" + edition;
    }
    
    public int getEdition()
    {
        return edition;
    }
    
    public boolean canSubstituteFor(Textbook that)
    {
        return (this.getTitle()).equals(that.getTitle()) &&
               this.edition >= that.edition;
    }


    
    public static void main(String[] args) {
        Textbook bio2015 = new Textbook("Biology", 49.75, 2);
        Textbook bio2019 = new Textbook("Biology", 39.75, 3);
        Textbook math = new Textbook("Calculus", 45.25, 1);
        System.out.println("bio2019.getEdition() should be 3: "
                           +bio2019.getEdition());
        System.out.println("bio2019.getBookInfo() should be Biology-39.75-3: "
                           +bio2019.getBookInfo());
        System.out.println("bio2019.canSubFor(bio2015) should be true: "
                           +bio2019.canSubstituteFor(bio2015));
        System.out.println("bio2015.canSubFor(bio2019) should be false: "
                           +bio2015.canSubstituteFor(bio2019));
        System.out.println("bio2015.canSubFor(math) should be false: "
                           +bio2015.canSubstituteFor(math));
    }
    
}
