package my.homework.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void findAll() {
        Repository repository = new Repository();
        Product[] expected = new Product[0];
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }


    @Test
    public  void add() {
        Repository repository = new Repository();
        Book book1 = new Book(1, "Sherlock Holmes 1", 300, "Doyle");
        Book book2 = new Book(2, "Twilight", 400, "Meyer");
        Book book3 = new Book(3, "Sherlock Holmes 2", 200, "Doyle");
        Smartphone smartphone = new Smartphone(4, "iphone 10", 50_000, "Apple");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone);

        Product[] expected = new Product[]{book1, book2, book3, smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {

        Repository repository = new Repository();
        Book book1 = new Book(1, "Sherlock Holmes 1", 300, "Doyle");
        Book book2 = new Book(2, "Twilight", 400, "Meyer");
        Book book3 = new Book(3, "Sherlock Holmes 2", 200, "Doyle");
        Smartphone smartphone = new Smartphone(4, "iphone 10", 50_000, "Apple");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone);

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book3, smartphone};

        Assertions.assertArrayEquals(expected, actual);


    }
}
