public class Car {
    private final String name;
    private int location;

    public Car(String name, int location) {
        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.location = location;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public void randomGo(int randomValue) {
        if (randomValue >= 4)
            go();
    }

    public void go() {
        this.location++;
    }

    public int max(int other) {
        return Math.max(location, other);
    }

    public boolean isSameLocation(int other) {
        return location == other;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
