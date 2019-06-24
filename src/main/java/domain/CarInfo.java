package domain;

import java.util.Random;

public class CarInfo implements MovableStrategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int FORWARD_NUM = 4;
    private static final String RESULT_DISPLAY_UNIT = "-";

    private final String carName;
    private int carPosition = 1;
    private GameResult result;

    public CarInfo(String carName, int time) {

        this.carName = carName;
        this.result = new GameResult(carName, time, RESULT_DISPLAY_UNIT);
    }

    public String getCarName() {
        return carName;
    }

    public GameResult getResult() {
        return result;
    }

    // 랜덤함수 결과 여부에 따라서 전진 or 정지를 결정하는 함수
    public void move(int time) {
        if (isMove()) {
            this.carPosition++;
            recordResult(time); // 랜덤값 4이상일때 결과 값 업데이트
        }
        recordResult(time); // 랜덤값 4이하 일떄도 이전과 동일한 결과 값 업데이트
    }

    // 랜덤함수의 결과가 4이상 이면 true/ 4이하이면 false 리턴하는 함수
    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= FORWARD_NUM;
    }

    // Max Position 을 리턴하는 함수
    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.carPosition);
    }

    // 자동차의 위치를 상태로 변경해주는 함수 (결과를 출력할때 로직추가 없이 바로 자동차 상태를 변경하기 위해 추가)
    private void recordResult(int time) {
        StringBuilder status = new StringBuilder();

        for (int i = 0; i < this.carPosition; ++i) {
            status.append(RESULT_DISPLAY_UNIT);
        }
        this.result.record(status.toString(), time);
    }

    // maxpositon 값과 현재 자동차의 position 값이 같은지 비교
    public boolean compareWithMaxPosition(int maxpositon) {
        return this.carPosition == maxpositon;
    }

}