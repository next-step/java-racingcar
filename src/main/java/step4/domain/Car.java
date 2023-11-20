package step4.domain;

public class Car {
    private Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String name() {
        return this.name.name();
    }
}
