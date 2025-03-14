public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public void go() {
        this.location++;
    }

    public void stop() {}

    public int getLocation() {
        return this.location;
    }

}
