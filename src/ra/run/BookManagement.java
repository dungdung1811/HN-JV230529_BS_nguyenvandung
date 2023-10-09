package ra.run;

import ra.bussinessImp.Book;
import ra.bussiness.IBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private static List<Book> books = new ArrayList<>();


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choise;
        do {
            System.out.println("**************** MENU ***************");
            System.out.println("1. Nhập số sách và nhập thông tin sách ");
            System.out.println("2. Hiển thị thông tin các sách ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách ");
            System.out.println("7. Thoát");
            choise = Integer.parseInt(scanner.nextLine());
            switch (choise){
                case 1:
                    inputBooks();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBooksByProfit();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    changeStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không có trong Menu");
            }


        } while (choise != 7);
    }
    private static void inputBooks() {
        System.out.print("Nhập số sách cần thêm: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numBooks; i++) {
            Book book = new Book();
            book.inputData();
            books.add(book);
        }
        System.out.println("Đã thêm " + numBooks + " sách.");
    }
    private static void displayBooks() {
        System.out.println("Thông tin các sách:");
        for (Book book : books) {
            book.displayData();
            System.out.println("------------------------------");
        }
    }

    private static void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookIdToDelete = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getBookId() == bookIdToDelete) {
                books.remove(book);
                System.out.println("Đã xóa sách có mã " + bookIdToDelete);
                return;
            }
        }
        System.out.println("Không tìm thấy sách có mã " + bookIdToDelete);
    }
    private static void searchByName() {
        boolean found = false;
        System.out.print("Nhập tên sách cần tìm: ");
        String bookNameSeach = String.valueOf(scanner.nextLine());
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(bookNameSeach.toLowerCase())) {
                book.displayData();
                found = true;
            }
        }
        if (!found){
            System.out.println("Không tìm thấy tên sách ");
        }

    }
    private static void sortBooksByProfit() {
        books.sort(Book::compareTo);
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
    }


    private static void changeStatus(){
        System.out.println("Nhập mã sách cần thay dổi trạng thái");
        int bookchangeStatusId = Integer.parseInt(scanner.nextLine());
        for (Book book: books) {
            if (book.getBookId() == bookchangeStatusId ){
                book.setBookStatus(!book.getBookStatus());
                System.out.println("Đã thay đổi trạng thái của sách có mã " + bookchangeStatusId);
                return;
            }
        }
        System.out.println("Không tìm thấy sách có mã " + bookchangeStatusId);

    }

}
