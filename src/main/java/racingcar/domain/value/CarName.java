package racingcar.domain.value;

public class CarName {

    private final String name;

    private CarName(String name) {

        this.name = name;
    }

    public static CarName create(String name) {

        return new CarName(name);
    }

    public String getName() {

        return name;
    }
}
