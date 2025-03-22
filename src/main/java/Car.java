public class Car {
    private final String name;
    private final Location location;

    public Car(String name, int location) {
        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.location = new Location(location);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public void go(MoveStrategy moveStrategy) {
        if (moveStrategy.move())
            this.location.add(1);
    }

    public int max(int other) {
        return this.location.max(other);
    }

    public boolean isSameLocation(int other) {
        return this.location.isSame(other);
    }

    public int getLocation() {
        return this.location.getValue();
    }

    public String getName() {
        return this.name;
    }
}
