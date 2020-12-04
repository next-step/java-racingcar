package step4;

public class Car {

    private static final int MAX_LENGHT = 5;
    private String name;
    private StringBuilder distance;

    public Car(String name) {
        setName(name);
        this.distance = new StringBuilder();
    }

    public void move(int random) {
        if (Checkor.check(random)) {
            distance.append("-");
        }
    }

    public String getDistance() {
        return distance.toString();
    }

    private void setName(String name) {
        if (name == null || name.length() > MAX_LENGHT) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + getDistance();
    }
}
