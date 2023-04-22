package my.homework.ru;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result = addProductToArray(result, product);
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    private Product[] addProductToArray(Product[] array, Product product) {
        Product[] tmp = new Product[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = product;
        return tmp;
    }

}

