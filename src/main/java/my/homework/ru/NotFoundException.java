package my.homework.ru;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int removeId) {
        super("Element with id: " + removeId + " not found");
    }
}


