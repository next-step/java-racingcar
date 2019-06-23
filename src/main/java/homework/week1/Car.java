package homework.week1;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car(String name) {
        this.name = name;
    }
}
