package racing.domain;

import org.apache.commons.lang3.StringUtils;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String carName) {
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException();
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public Car deepCopyCar() {
        Car copyCar = new Car(this.name);
        copyCar.position = this.position;

        return copyCar;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
