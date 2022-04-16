package study.step3;

import java.util.*;

public class RacingcarGame {

    private int numberOfCar;
    private int numberOfAttempt;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private List<Racingcar> racingcarList = new ArrayList<>();
    private List<Map<Integer, Integer>> list = new ArrayList<>();

    public RacingcarGame() {
        configRacingcarGame();
        createRacingcar();
    }

    private void configRacingcarGame() {
        System.out.println("자동차의 대수는 몇 대 인가요?");
        numberOfCar = inputView.getNumber();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        numberOfAttempt = inputView.getNumber();
        System.out.println("실행결과");
    }

    private void createRacingcar() {
        for(int i = 0; i < numberOfCar; i++) {
            racingcarList.add(new Racingcar());
        }
    }

    public void startRacingcarGame() {
        for (int i = 1; i <= numberOfAttempt; i++) {
            for (Racingcar car : racingcarList) {
                car.tryToMoveForward();
                resultView.print(i, car);
            }
            System.out.println(" ");
        }
    }
}
