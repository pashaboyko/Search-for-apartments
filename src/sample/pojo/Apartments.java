package sample.pojo;

public class Apartments extends Home
{
    private int floor ;
    private String color;
    private Boolean cityCenter;

    public Apartments(int id, String n, String bar, double pr, double s,String photo, int floor,  String col, Boolean seas)
    {
        super(id,n,bar,pr,s,photo);
        this.floor=floor;
        this.color=col;
        this.cityCenter=seas;
    }
    public Apartments()
    {
        super();
    }
    public Apartments(Apartments another)
    {
        super(another);
        this.floor=another.floor;
        this.color=another.color;
        this.cityCenter=another.cityCenter;
    }

    public String getColor()
    {
        return color;
    }
    public void setColor(String c)
    {
        this.color=c;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Boolean getCityCenter() {
        return cityCenter;
    }

    public void setCityCenter(Boolean cityCenter) {
        this.cityCenter = cityCenter;
    }
}