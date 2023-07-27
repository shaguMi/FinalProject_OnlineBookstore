package Belajar;

import java.util.*;
    
    public class Online_BookStore {
        static ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        public static void main(String[] args) {
        System.out.println("Selamat Datang Di Toko Buku Online - Team-TWO");
        System.out.println(" ");

        ArrayList<Category> listCategory = createBookCategories();
        ArrayList<Book> listBook = createBooks(listCategory);

        HashMap<Category, ArrayList<Book>> listBookCategory = new HashMap<Category, ArrayList<Book>>();

        for (Book book : listBook) {

                // Category is empty
                if(!listBookCategory.containsKey(book.getCategory())){
                        // Create a new list of book
                        ArrayList<Book> books = new ArrayList<Book>();
                        books.add(book);

                        // Add a new key value pair
                        listBookCategory.put(book.getCategory(), books);
                }

                //Category exists
                else{
                        listBookCategory.get(book.getCategory()).add(book);
                }
        }       
        boolean ulangi = false;
        do
        {
                 ulangi = frontPage(listCategory,listBookCategory);
        }
        while (ulangi == true);

        double totHarga = 0.0;
        System.out.println("===============================================");
        System.out.println("Buku yang akan dibeli : ");
        for (int i = 1; i <= checkedOutBooks.size(); i++) {
                Book book = checkedOutBooks.get(i-1);
                System.out.println(i+". "+book.getName()+" - "+book.getAuthor()+" - Rp. "+book.getPrice());
        totHarga += book.getPrice();
        }
        System.out.println("==============================================");
        System.out.println("Total Pembelian Buku : Rp. "+ totHarga);
        System.out.println("");
        System.out.println("Silahkan menyelesaikan pembayaran Anda di kasir");
        System.out.println("");
        System.out.println("");
        System.out.println("Terima kasih telah berbelanja ke Toko Buku - Team TWO"); 
    }
    
    // Method add Book category list
    public static ArrayList<Category> createBookCategories(){
        ArrayList<Category> listCategory = new ArrayList<Category>();
        listCategory.add(new Category(1, "Fiksi"));
        listCategory.add(new Category(2, "Dokumentari"));
        listCategory.add(new Category(3, "Travel"));
        listCategory.add(new Category(4, "Informatika"));

        return listCategory;
    }

    // Method add Book list all
    public static ArrayList<Book> createBooks(ArrayList<Category> listCategory){
        ArrayList<Book> listBook = new ArrayList<Book>();
        listBook.add(Book.CreateNewBook("To Kill a Mockingbird", "Harper Lee", 199000, listCategory.get(0)));
        listBook.add(Book.CreateNewBook("1984", "George Orwell", 49000, listCategory.get(0)));
        listBook.add(Book.CreateNewBook("Pride and Prejudice", "Jane Austen", 49000, listCategory.get(0)));
        listBook.add(Book.CreateNewBook("The Hunger Games", "Suzanne Collins", 99000, listCategory.get(0)));
        listBook.add(Book.CreateNewBook("The Lord of the Ringss", "J.R.R. Tolkien", 259000, listCategory.get(0)));
        listBook.add(Book.CreateNewBook("Directing the Documentary", "Michael Rabiger",300000, listCategory.get(1)));
        listBook.add(Book.CreateNewBook("Dokumenter Sebagai Tanda","Syamsul Rizal",90000, listCategory.get(1)));
        listBook.add(Book.CreateNewBook("Cinematography untuk Dokumenter","Lintang Cahyaningsih",125000,listCategory.get(1)));
        listBook.add(Book.CreateNewBook("Dokumenter Video Jurnalistik","Wimar Witoelar",75000,listCategory.get(1)));
        listBook.add(Book.CreateNewBook("Membuat Film Dokumenter","Fikar W Eda",60000, listCategory.get(1)));
        listBook.add(Book.CreateNewBook("The Naked Traveler: 1 Year Round-the-World Trip","Trinity",110000, listCategory.get(2)));
        listBook.add(Book.CreateNewBook("Backpacker Jalan-Jalan","Gede Suardana",70000, listCategory.get(2)));
        listBook.add(Book.CreateNewBook("Jalan Jalan: 111 Cerita yang Menyadarkan Kita Bahwa Hidup Itu Indah","Adhitya Mulya",95000, listCategory.get(2)));
        listBook.add(Book.CreateNewBook("Selimut Debu","Agustinus Wibowo",135000, listCategory.get(2)));
        listBook.add(Book.CreateNewBook(" Exploring the Improbable Nation","Elizabeth Pisani",120000, listCategory.get(2)));
        listBook.add(Book.CreateNewBook("Buku Dasar-Dasar Teknik Informatika","Novega Pratama Adiputra",83000,listCategory.get(3)));
        listBook.add(Book.CreateNewBook("Pengantar Teknologi Informasi","Buhori Muslim",112000, listCategory.get(3)));
        listBook.add(Book.CreateNewBook("Metode Penelitian Teknik Informatika","Ade Johar Maturidi",120000, listCategory.get(3)));
        listBook.add(Book.CreateNewBook("Komputer Cerdas untuk Mahasiswa Teknik Informatika","Nur Nafi'iyah",155000,listCategory.get(3)));
        listBook.add(Book.CreateNewBook("Buku Aplikasi Komputer","Dwi Krisbiantoro",100000,listCategory.get(3)));
        
        return listBook;
    }

    // Method frontpage
    public static boolean frontPage(ArrayList<Category> listCategory,HashMap<Category, ArrayList<Book>> listBookCategory){
        Scanner scanCategory = new Scanner(System.in);
        System.out.println("List Kategori Buku yang Tersedia Saat Ini : ");
        System.out.println(" ");

        for (Category category : listCategory) {
            System.out.println(category.id + ". " + category.name);
        }

        System.out.println(" ");
        System.out.print("Silahkan pilih kategori buku yang akan kamu beli: ");
        int selectedCatId = scanCategory.nextInt();

        HashMap<Integer, Book> listBookByCat = new HashMap<Integer, Book>();
        for (Category category : listCategory) {
            if (category.id == selectedCatId) {
                System.out.println("List buku dari kategori " + category.name+" :");
                ArrayList<Book> bookList = listBookCategory.get(category);
                for (int i = 1; i <= bookList.size(); i++) {
                        Book book = bookList.get(i-1);
                        System.out.println(i + ". " + book.getName()+" - "+book.getAuthor()+" - Rp. "+book.getPrice());
                        listBookByCat.put(i, book);
                }
                break;
            }
        }
        System.out.println("");
        Scanner scanAns = new Scanner(System.in);
        System.out.print("Apakah ada buku yang kamu cari [y/t]: ");
        String cari = scanAns.nextLine();
        if (cari.equalsIgnoreCase("t")) {
            return true;
        }

        boolean validInput;
        do {
            validInput = true;
            String jawaban = scanAns.nextLine();
            System.out.print("Pilih buku yang akan dibeli(jika lebih dari 1 maka gunakan koma) :");
            String pilihBook = scanAns.nextLine();

             // make arraylist choices
            String [] selectedBooks = pilihBook.split(",");
            for (String selectedBookStr : selectedBooks) {
                try {
                    int selectedBookInt = Integer.parseInt(selectedBookStr);
                    Book book = listBookByCat.get(selectedBookInt); 
                    checkedOutBooks.add(book);   
            
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka atau angka dipisahkan oleh koma. Contoh: 1,2,3"); 
                validInput = false;
                break; //keluar dari loop, mengulangi pemilihan buku
            }        
        } 
        
    } while (!validInput);
        System.out.println("");
        System.out.print("Apakah anda mencari buku yang lain [y/t] : ");
        String jawaban = scanAns.nextLine();

        if (jawaban.equalsIgnoreCase("y")) {
                return true;
        } else 
        {
                return false;
        }
    }
}


