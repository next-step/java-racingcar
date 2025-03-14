public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public void go() {
        this.location++;
    }

    public int getLocation() {
        return this.location;
    }

}
