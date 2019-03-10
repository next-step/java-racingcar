package racingcar;

import racingcar.car.PowerGenerator;

import static racingcar.RacingGameStatusViewer.showRacingGameStatus;

public class RacingGame {
    private int time;
    private int cars;
    private int[] carPositions;
    private PowerGenerator powerGenerator;

    public RacingGame(int cars, int time) {
        this.cars = cars;
        this.time = time;
        this.carPositions = new int[cars];
        this.powerGenerator = new PowerGenerator();
    }

    public void move() {
        for (int i = 0; i < time; i++) {
            powerGenerator.determineMoveOrNot(carPositions);
            showRacingGameStatus(carPositions);
        }
    }

    //19.03.10 - step1 피드백, movePower 객체로 분리

    //19.03.10 - step1 피드백, 테스트를 위한 인스턴스 변수 getter제거
    //대신 최종결과를 확인하기 위한 method 생성
    public int[] loadResultofGame() {
        return carPositions;
    }
}

