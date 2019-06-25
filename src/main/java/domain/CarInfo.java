package domain;

import java.util.Random;

public class CarInfo implements MovableStrategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int FORWARD_NUM = 4;

    private final String carName;
    private int[] carPosition;
    private int indexOftime;

    public CarInfo(String carName, int time) {

        this.carName = carName;
        this.indexOftime = time;
        this.carPosition = new int[time];
        this.carPosition[0] = 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarLastPosition() {
        return carPosition[indexOftime - 1];
    }

    // 랜덤함수 결과 여부에 따라서 전진 or 정지를 결정하는 함수
    public void move(int time) {
        if (isMove()) {
            carPosition[time] = carPosition[time - 1] + 1;
            return;
        }
        carPosition[time] = carPosition[time - 1]; // 랜덤값 4이하 일떄도 이전과 동일한 결과 값 업데이트
    }

    // 랜덤함수의 결과가 4이상 이면 true/ 4이하이면 false 리턴하는 함수
    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= FORWARD_NUM;
    }

    // Max Position 을 리턴하는 함수
    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.carPosition[indexOftime - 1]);
    }

    // maxpositon 값과 현재 자동차의 position 값이 같은지 비교
    public boolean compareWithMaxPosition(int maxpositon) {
        return this.carPosition[indexOftime - 1] == maxpositon;
    }

}