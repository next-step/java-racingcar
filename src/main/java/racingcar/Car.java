package racingcar;

public class Car {

    private String name;

    public Car(String name) {
        if(name.length() > 5) throw new IllegalArgumentException();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
