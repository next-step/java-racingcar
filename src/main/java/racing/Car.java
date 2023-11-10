package racing;

public class Car {
    private int distance = 1;
    private final Name name;
    private Car(Name name) {
        this.name = name;
    }
    public static Car defaultOf(String name) {
        return new Car(Name.defaultOf(name));
    }
}
