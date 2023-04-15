package step3.model;

import java.util.function.UnaryOperator;

public class Car {
    private static final UnaryOperator<String> validateName = name -> {
        if (name.length() <= 5) {
            return name;
        }
        throw new IllegalArgumentException("자동차 이름은 5자를 초과할수 없다");
    };
    private final String name;

    public Car(String name) {
        this.name = validateName.apply(name);
    }

    public String getName() {
        return this.name;
    }
}
