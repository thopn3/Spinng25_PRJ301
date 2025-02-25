package entities;

public class Product {
    private int id;
    private String name;
    private double price;
    private String images; // Chứa đường dẫn các ảnh, phân tách bởi dấu ;

    public Product(int id, String name, double price, String images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
