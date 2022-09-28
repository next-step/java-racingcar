package step4;

import java.util.Objects;

public class Car {

    private String carName;
    private int location = 0;

    public Car(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    private void validateName(String carName) {
        if(Objects.isNull(carName) || carName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 널이나 공백이 들어올 수 없습니다.");
        }
    }

    void moveForward(boolean isMovable) {
        if (isMovable) {
            this.location++;
        }
    }

    public String getCarName(){
        return this.carName;
    }

    public int getLocation() {
        return this.location;
    }
}
