package step4.controller;

import step4.util.RandomNumberGenerator;
import step4.domain.Car;
import step4.domain.Cars;
import step4.view.ResultView;

public class PlayGame {
    private final Cars cars;
    private final ResultView resultView;

    public PlayGame(Cars cars, ResultView resultView) {
        this.cars = cars;
        this.resultView = resultView;
    }

    public void gameStart(int round) {
        checkRoundNum(round);
        resultView.printResultView();
        for (int i = 0; i < round; i++) {
            playRound();
            resultView.separateRound();
        }
        resultView.printWinners(cars.findWinners());
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            resultView.printCarName(car);
            resultView.printCarLocation(car.getLocation());
            car.move(RandomNumberGenerator.getRandomGenerator());
        }
    }

    private static void checkRoundNum(int round) {
        if(round <1)
            throw new IllegalArgumentException("최소 한 라운드 이상은 진행해야함");
    }

}
