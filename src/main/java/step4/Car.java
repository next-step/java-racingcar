package step4;

import step4.checkor.AdvanceCheckor;
import step4.checkor.Checkor;

public class Car {

    private static final int MAX_LENGHT = 5;
    private String name;
    private StringBuilder distance;
    private Checkor checkor;

    public Car(String name) {
        setName(name);
        this.distance = new StringBuilder();
        this.checkor = new AdvanceCheckor();
    }

    public void move(int random) {
        if ((Boolean) checkor.check(random)) {
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + getDistance();
    }
}
