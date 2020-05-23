package racecar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static void main(String[] args) {
        //입력
        String[] carName = InputView.askCarNames();
        int repeatCount = InputView.askRepeatCount();

        //게임 준비
        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.ready(carName);

        //게임 실행
        for (int i = 0; i < repeatCount; i++) {
            racingGame.start(carList);
            System.out.println();
        }

        //우승자 발표
        racingGame.announceWinner(carList);

    }

    private List<Car> ready(String[] carName) {
        List<Car> carList = new ArrayList<>();
        for (String name : carName) {
            carList.add(Car.generate(name));
        }
        return carList;
    }

    private void start(List<Car> carList) {
        Random random = new Random();
        for (Car car : carList) {
            car.move(random);
            ResultView.printStatus(car);
        }
    }

    private void announceWinner(List<Car> carList) {
        int max = getWinScore(carList);
        List<String> winners = selectWinner(carList, max);
        ResultView.printWinner(winners);
    }

    private int getWinScore(List<Car> carList) {
        List<Integer> scores = new ArrayList<>();
        for (Car car : carList)
            scores.add(car.getPosition());
        int max = Collections.max(scores);
        return max;
    }

    private List<String> selectWinner(List<Car> carList, int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (max == car.getPosition())
                winners.add(car.getName());
        }
        return winners;
    }
}
