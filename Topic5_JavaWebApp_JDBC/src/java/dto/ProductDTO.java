package dto;
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String cName;

    public ProductDTO(int id, String name, int price, int quantity, String cName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cName = cName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
    
    
}
