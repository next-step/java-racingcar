public class Car {
    private String name;
    private int distance;

    Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = 0;
    }

    Car(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }
}
