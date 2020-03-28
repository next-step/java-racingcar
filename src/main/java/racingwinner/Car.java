package racingwinner;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this(name,0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
