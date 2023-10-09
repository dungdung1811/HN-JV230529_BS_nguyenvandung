package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook {
//   Attribute
   private int bookId;
   private String bookName;
   private String title;
   private int numberOfPages;
   private float importPrice;
   private float exportPrice;
   private float interest;
   private Boolean bookStatus;

   public Book() {
   }

   public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, Boolean bookStatus) {
      this.bookId = bookId;
      this.bookName = bookName;
      this.title = title;
      this.numberOfPages = numberOfPages;
      this.importPrice = importPrice;
      this.exportPrice = exportPrice;
      this.interest = interest;
      this.bookStatus = bookStatus;
   }

   public int getBookId() {
      return bookId;
   }

   public void setBookId(int bookId) {
      this.bookId = bookId;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getNumberOfPages() {
      return numberOfPages;
   }

   public void setNumberOfPages(int numberOfPages) {
      this.numberOfPages = numberOfPages;
   }

   public float getImportPrice() {
      return importPrice;
   }

   public void setImportPrice(float importPrice) {
      this.importPrice = importPrice;
   }

   public float getExportPrice() {
      return exportPrice;
   }

   public void setExportPrice(float exportPrice) {
      this.exportPrice = exportPrice;
   }

   public float getInterest() {
      return interest;
   }

   public void setInterest(float interest) {
      this.interest = interest;
   }

   public Boolean getBookStatus() {
      return bookStatus;
   }

   public void setBookStatus(Boolean bookStatus) {
      this.bookStatus = bookStatus;
   }

   @Override
   public void inputData() {
      System.out.println("Nhập vào thông tin sách");
      Scanner scanner = new Scanner(System.in);
      System.out.println("Nhập vào Id của sách");
      this.bookId = Integer.parseInt(scanner.nextLine());
      System.out.println("Nhập vào tên sách ");
      this.bookName = scanner.nextLine();
      System.out.println("Nhập vào tiêu đề sách ");
      this.title = scanner.nextLine();
      System.out.println("Nhập vào số trang sách");
      this.numberOfPages = Integer.parseInt(scanner.nextLine());
      System.out.println("Nhập vào giá nhập sách ");
      this.importPrice = Float.parseFloat(scanner.nextLine());
      System.out.println("Nhập vào giá bán sách ");
      this.exportPrice = Float.parseFloat(scanner.nextLine());
      System.out.println("Nhập vào trạng thái ");
      this.bookStatus = Boolean.valueOf(scanner.nextLine());
      this.interest = this.exportPrice - this.importPrice;
   }

   @Override
   public void displayData() {
      System.out.println("Hiển thị thông tin sách");
      System.out.println("Mã sách: " + this.bookId);
      System.out.println("Tên sách: " + this.bookName);
      System.out.println("Tiêu đề: " + this.title);
      System.out.println("Số trang: " + this.numberOfPages);
      System.out.println("Giá nhập: " + this.importPrice);
      System.out.println("Giá bán: " + this.exportPrice);
      System.out.println("Lãi suất: " + this.interest);
      System.out.println("Trạng thái sách: " + this.bookStatus);
   }



   @Override
   public int compareTo(Book o) {
      return (int) - (this.getInterest() - o.getInterest());
   }
}
