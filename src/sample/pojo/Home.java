package sample.pojo;

public class Home {

    private int id;
    private String name;
    private String street;
    private double price;
    private double square;



    private String photo;

    public Home(int id, String name, String street, double price, double square, String photo) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.price = price;
        this.square = square;
        this.photo = photo;
    }

    public Home() {

    }
    public Home(Home another) {
        this.id=another.id;
        this.street=another.street;
        this.name=another.name;
        this.price=another.price;
        this.square=another.square;
        this.photo=another.photo;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSquare() {
        return square;
    }
    public void setSquare(double square){
        this.square=square;

    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String setPhoto(){
        return photo;
    }
}
