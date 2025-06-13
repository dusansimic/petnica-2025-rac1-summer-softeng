import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

interface BookIterator {
    boolean hasNext();

    Book next();
}

class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public BookIterator iterator() {
        return new BookCollectionIterator();
    }

    // Inner class implementing the iterator
    private class BookCollectionIterator implements BookIterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            return books.get(index++);
        }
    }
}

public class BookIteratorPattern {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBook(new Book("Clean Code"));
        collection.addBook(new Book("Design Patterns"));
        collection.addBook(new Book("Refactoring"));

        BookIterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book: " + book.getTitle());
        }
    }
}
