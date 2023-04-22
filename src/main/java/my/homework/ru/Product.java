package my.homework.ru;

public class Product {

    public Product(int id, String title, int price) {
        this.id = id;
        this.Name = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }


    protected int id;
    protected String Name;
    protected int price;
}
