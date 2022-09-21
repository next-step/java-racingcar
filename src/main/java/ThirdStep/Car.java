package ThirdStep;

public class Car {

    private int location;

    public Car() {
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        ++location;
    }

    public void printLocation() {
        String LOCATION_SIGN = "-";
        System.out.println(LOCATION_SIGN.repeat(location));
    }
}
