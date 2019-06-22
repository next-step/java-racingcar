package domain;

import java.util.Random;

public class CarInfo implements MovableStrategy {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_RANDOM_NUMBER = 10;

    private final String carName;
    private int carPosition = 1;

    public CarInfo(String carName) {
        this.carName = carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarPositions(int carPosition) {
        this.carPosition = carPosition;
    }

    // 랜덤함수 결과 여부에 따라서 전진 or 정지를 결정하는 함수
    public void move() {
        if (isMove()) {
            carPosition++;
        }
    }

    // 랜덤함수의 결과가 4이상 이면 true/ 4이하이면 false 리턴하는 함수
    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= FORWARD_NUM;
    }
}
