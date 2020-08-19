package carracing.domain;

import java.util.Random;

public class Car {

    private int position = 0;
    private String carName;

    public Car(String carName) {
        validCarName(carName);
        this.carName = carName;
    }

    private void validCarName(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할수 없습니다.");
        }
    }

    public int getPower() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void setPosition(CarCondition carCondition) {
        if(carCondition.isMovable()) {
            position++;
        }
        return;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}