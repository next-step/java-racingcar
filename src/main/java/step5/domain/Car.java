package step5.domain;

public class Car {
    private final Name name;

    private Car(Name name) {
        this.name = name;
    }

    public static Car defaultOf(String name) {
        Name nameObject = Name.of(name);
        return new Car(nameObject);
    }
}
