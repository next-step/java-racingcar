package step3;

import step2.StringUtils;

import java.util.Objects;

public class Car {

    String name;

    int movingDistance = 0;

    private NameValidator nameValidator = new NameValidator();

    public Car(String name) {
        nameValidator.validate(name);
        this.name = name;
    }

    public void moveIf(MoveCondition condition) {
        if (condition.match()) movingDistance++;
    }

    private class NameValidator {
        private final int MAX_LENGTH = 5;

        public boolean validate(String name) {
            if (StringUtils.isNullOrBlank(name)) throw new InvalidCarNameException(name);
            if (name.length() > MAX_LENGTH) throw new InvalidCarNameException(name);

            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

