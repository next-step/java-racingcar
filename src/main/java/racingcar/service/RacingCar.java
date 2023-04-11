package racingcar.service;

public class RacingCar {
    final static int CAR_MOVEMENT_PERCENTAGE = 4;
    final static int DEFAULT_MOVEMENT_DISTANCE = 1;
    private String carNumber;
    private String position;

    public RacingCar(String carNumber) {
        this.carNumber = carNumber;
    }

    // random 확률 계산기
    public int calculateRandomNumber() {
        double randomValue = Math.random();
        int probability = (int)(randomValue * 10);

        return probability;
    }

    // 40% 확률로 DEFAULT_MOVEMENT_DISTANCE 만큼 자동차 이동
    public void moveForward(int probability) {
        if(probability >= CAR_MOVEMENT_PERCENTAGE) {
            this.position += DEFAULT_MOVEMENT_DISTANCE;
        }
    }


}
