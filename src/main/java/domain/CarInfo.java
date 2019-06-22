package domain;

import java.util.Random;

public class CarInfo implements MovableStrategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int FORWARD_NUM = 4;

    private final String carName;
    private int carPosition = 1;
    private String carStatus = "-";

    public CarInfo(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarStatus() {
        return carStatus;
    }

    // 랜덤함수 결과 여부에 따라서 전진 or 정지를 결정하는 함수
    public void move() {
        if (isMove()) {
            carPosition++;
            makeStatusofCar(); // 자동차의 위치가 변경될때 마다 자동차도 상태도 업데이트 시켜줌
        }
    }

    // 랜덤함수의 결과가 4이상 이면 true/ 4이하이면 false 리턴하는 함수
    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= FORWARD_NUM;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.carPosition);
    }

    // 자동차의 위치를 상태로 변경해주는 함수 (결과를 출력할때 로직추가 없이 바로 자동차 상태를 변경하기 위해 추가)
    private void makeStatusofCar() {
        StringBuilder status = new StringBuilder();

        for (int i = 0; i < this.carPosition; ++i) {
            status.append("-");
        }
        this.carStatus = status.toString();
    }

    // maxpositon 값과 현재 자동차의 position 값이 같은지 비교
    public boolean compareWithMaxPosition(int maxpositon) {
        return this.carPosition == maxpositon;
    }

}
