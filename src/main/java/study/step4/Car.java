package study.step4;

import java.util.Objects;

public class Car {
    private final static int INIT_ZERO = 0;
    private final static int INT_ONE = 1;
    private final static String CAR_NAME_EXCEPTION = "차 이름은 빈값으로 할 수 없습니다. 제대로 입력해주세요";
    private final static String CAR_POSITION_EXCEPTION = "차 위치는 0보다 작은 수로 시작할 수 없습니다.";

    private final String carName;
    private final int carPosition;

    public Car(String carName) {
       this(carName, INIT_ZERO);
    }

    public Car(String carName, int carPosition) {
        validateCarName(carName);
        validateCarPosition(carPosition);
        
        this.carName = carName;
        this.carPosition = carPosition;
    }

    private void validateCarPosition(int carPosition) {
        if (carPosition < INIT_ZERO){
            throw new IllegalArgumentException(CAR_POSITION_EXCEPTION);
        }
    }

    private void validateCarName(String carName) {
        if (Objects.isNull(carName) || carName.trim().isEmpty()){
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION);
        }
    }

    public Car move(CarMoveCondition moveCondition){
        if (moveCondition.isCarMoveCondition()){
            return new Car(carName,increaseCarPosition());
        }
        return this;
    }
    public String getCarName(){
        return carName;
    }

    public int getCarPosition(){
        return carPosition;
    }

    private int increaseCarPosition() {
        return carPosition + INT_ONE;
    }

    public boolean isChampionsPosition(int maxPosition){
        return this.carPosition == maxPosition;
    }
}
