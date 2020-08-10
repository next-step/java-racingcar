package racing.car.model;

public class Car {

    private int id;
    private int location;

    public Car(int id, int location) {
        this.id = id;
        this.location = location;
    }

    public void go() {
        location++;
    }

    public int getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

}
