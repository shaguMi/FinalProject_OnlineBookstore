package Belajar;

public class Book {

    // class member
    private String name;
    private double price;
    private String author;
    // private String category;
    // private int idCat;
    private Category category;

    public void Book() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }

    public static Book CreateNewBook(String name, String author,double price, Category category) {
        Book newBook = new Book();
        newBook.setName(name);
        newBook.setPrice(price);
        newBook.setAuthor(author);
        newBook.setCategory(category);

        return newBook;
    }
}
