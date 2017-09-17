/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Yogi Riandisa
 */
//public class JavaApplication1 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//    
//}

/*
* README
* ======
*
* This is simple source code for bookstore application.
* The functional requirement that you needed to help you understand the user story has been written.
*
* Your mission is :
*
* 1. Complete these source code at "PLACE YOUR CODE HERE" parts and run them without any error.
* 2. The result has to be:
*    1:true
*    2:true
*    3:true
*    4:true
*    5:true
* 3. Send the source code file with your answers.
*/

import java.util.*;

public class JavaApplication1 {

    public static void main(String[] args) {

        Shop shop = new Shop();

        List<Book> books = Arrays.asList(
            new Book("The Fellowship of the Ring", "J.R.R. Tolkien"),
            new Book("The Two Towers", "J.R.R. Tolkien"),
            new Book("The Return of the King", "J.R.R. Tolkien"),
            new Book("The Hobbit", "J.R.R. Tolkien"),
            new Book("Harry Potter and the Sorcerer\"s Stone", "J.K. Rowling"),
            new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling"),
            new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling"),
            new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling"),
            new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling"),
            new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling"),
            new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling")
        );

        for (Book book : books) {
            shop.bookAdd(book);
        }

        // Ahmad goes to the bookstore.
        // He looks for a book title "Two Towers"
        // If the book is there, he puts it on book cart.

        Person ahmad = new Person("Ahmad Ramadhan");
        Boolean available = shop.bookIsAvailable("The Two Tower");
        
        shop.showData();
        
        if(available) {

            Book book = shop.bookGet("The Two Towers");
            ahmad.addToBag(book);

            System.out.println("1: true");
        } else {
            System.out.println("1: false");
        }

        // Ahmad goes to bookcase collection from author J.K. Rowling
        // He looks for a book title "Harry Potter and The Goblet of Fire" from author J.K Rowling
        // If the book is there, he puts it on book cart.

        List<String> rowlingBooks = shop.bookListByAuthor("J.K. Rowling");

        if(rowlingBooks.contains("Harry Potter and the Goblet of Fire")) {

            Book book = shop.bookGet("Harry Potter and the Goblet of Fire");
            ahmad.addToBag(book);

            System.out.println("2: true");
        } else {
            System.out.println("2: false");
        }

        // Ahmad has finished choose the books and goes to cashier.
        // He checked the bookcart and sees that there are 2 books on bookcart

        if(ahmad.countBag() == 2) {
            System.out.println("3: true");
        } else {
            System.out.println("3: false");
        }

        // Ahmad finished buy the books





        // Bayu goes to the bookstore.
        // He looks for a book that he only remembers part of the title is "The King" in entire bookcase.
        // After he finds 1 book with title matched, he puts in on bookcart.

        Person bayu = new Person("Bayu Sakti");

        List<String> booksTheKing = shop.bookListByTitleContains("The King");

        if(booksTheKing.size() > 0 ){

            Book book = shop.bookGet(booksTheKing.get(0));
            bayu.addToBag(book);

            System.out.println("4: true");
        } else {
            System.out.println("4: false");
        }


        // Accidentally, He looks new arrival of the newest Harry potter's book series.
        // Then he put it on bookcart and turn book "The Return of The King" back to bookcase.

        Boolean availableBookTwoTowers = shop.bookIsAvailable("Harry Potter and the Deathly Hallows");

        if(availableBookTwoTowers) {
            Book book = shop.bookGet("Harry Potter and the Deathly Hallows");
            bayu.addToBag(book);
            bayu.removeFromBag("The Return of the King");
        }


        // Bayu has finished choose the books and goes to cashier.
        // He checked the bookcart and sees that there is 1 book on bookcart


        if (bayu.countBag() == 1) {
            System.out.println("5: true");
        } else {
            System.out.println("5: false");
        }

        // Bayu finished buy the books.
    }



    static class Shop {
        Book buku;
        int x=0;
        String judul, buku2;
        List<Book> books = Arrays.asList();
        
        void bookAdd(Book book){
            this.buku = book;
        }
        
        public void showData(){
            System.out.println(buku.getJudul(0));
        }
        
        Boolean bookIsAvailable(String getBook){
            for(Book book : books){
                if(getBook==book.getJudul(x)){
                    return true;
                }
                x++;
            }return false;
        }
        
        Book bookGet(String getBook2){
            buku2 = getBook2;
        }
        
//        private Book bookGet(String judul2){
//            
//            
//        }
    }

    static class Book {
        Book buku;
        int x=1, y=1;
        List<String> judul = new ArrayList<String>();
        List<String> pengarang = new ArrayList<String>();
        
        
        Book (String jdl, String png){
            judul.add(jdl);        
            pengarang.add(png);
        }
        
        public String getJudul(int x){
            return judul.get(x);
        }
        
        public String getPengarang(int x){
            return pengarang.get(x);
        }

//        void bookGet(String judul2){
//            this.judul = judul2;
//        }
        
    }

    static class Person {
        String nama;
        Book buku2;
        Person (String nm){
            nama = nm;
        }
        
        void addToBag(Book book){
            this.buku2 = book;
        }
    }
}
