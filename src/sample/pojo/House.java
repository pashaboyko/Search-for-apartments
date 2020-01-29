package sample.pojo;

public class House extends Home{
    private int floor ;
    private boolean onCity;
    private double squareAroundHouse;

    public House(int id, String n, String bar, double pr, double s,String photo, int floor, boolean onCity, double squareAroundHouse)
    {
        super(id,n,bar,pr,s,photo);
        this.floor=floor;
        this.onCity=onCity;
        this.squareAroundHouse = squareAroundHouse;
    }
    public House()
    {
        super();
    }
    public House(House another)
    {
        super(another);
        this.floor=another.floor;
        this.onCity=another.onCity;
        this.squareAroundHouse =another.squareAroundHouse;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isOnCity() {
        return onCity;
    }

    public void setOnCity(boolean onCity) {
        this.onCity = onCity;
    }

    public double getSquareAroundHouse() {
        return squareAroundHouse;
    }

    public void setSquareAroundHouse(double squareAroundHouse) {
        this.squareAroundHouse = squareAroundHouse;
    }
}
