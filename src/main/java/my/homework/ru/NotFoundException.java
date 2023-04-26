package my.homework.ru;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int Id) {
        super("Element with id: " + Id + " not found");
    }
}


