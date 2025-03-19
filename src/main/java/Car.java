public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public void randomGo(int randomValue) {
        if (randomValue >= 4)
            go();
    }

    public void go() {
        this.location++;
    }

    public int getLocation() {
        return this.location;
    }
}
