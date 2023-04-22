package my.homework.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testAddProduct() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Product product = new Product(1, "Test product", 100);
        manager.add(product);
        Product[] expected = {product};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatchingProducts() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Sherlock Holmes 1", 300, "Doyle");
        Book book2 = new Book(2, "Twilight", 400, "Meyer");
        Book book3 = new Book(3, "Sherlock Holmes 2", 200, "Doyle");
        Smartphone smartphone = new Smartphone(4, "iphone 10", 50_000, "Apple");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone);
        Product[] actual = manager.searchBy("Holmes");
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testIfNoMatches() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Sherlock Holmes 1", 300, "Doyle");
        Book book2 = new Book(2, "Twilight", 400, "Meyer");
        Book book3 = new Book(3, "Sherlock Holmes 2", 200, "Doyle");
        Smartphone smartphone = new Smartphone(4, "iphone 8", 50_000, "Apple");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAuthor() {
        Book book = new Book(1, "The Master and Margarita", 250, "Bulgakov");
        String expected = "Bulgakov";
        String actual = book.getAuthor();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetBrand() {
        Smartphone smartphone = new Smartphone(1, "iPhone X", 65_000, "Apple");
        String expected = "Apple";
        String actual = smartphone.getBrand();
        Assertions.assertEquals(expected, actual);
    }
}
