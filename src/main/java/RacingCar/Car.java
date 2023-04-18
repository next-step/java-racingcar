package RacingCar;

public class Car {

    private  int location;
    private  String name;

    public Car(int location,String name) {
        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(int location){
        this.location = location;
    }

}
