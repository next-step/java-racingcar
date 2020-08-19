package carracing.domain.car;

import carracing.domain.car.strategy.CarCondition;

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

    public void setPosition(CarCondition carCondition) {
        if(carCondition.isMovable()) {
            position += 1;
        }
        return;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isMaxPosition(int maxPosition) {
        return maxPosition <= position;
    }
}