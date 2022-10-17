package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGameInfo;
import racing.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars cars;
    private ResultView resultView = new ResultView();
    private Integer tryCount;

    RacingGame(RacingGameInfo racingGameInfo) {
        cars = new Cars(racingGameInfo.carNames);
        this.tryCount = racingGameInfo.tryCount;
    }

    public void tryEvent() {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("");
            play(cars);
        }

        Car winnerCar = getWinners(cars).stream()
                .max((c1, c2) -> Integer.compare(c1.getDistance(), c2.getDistance()))
                .get();

        resultView.printWinner(winnerCar);
    }

    private void play(Cars cars) {
        cars.moveEvent();
        resultView.result(cars);
    }

    private List<Car> getWinners(Cars cars) {
        return cars.getCars().stream()
                .sorted(Comparator.comparing(Car::getDistance).reversed())
                .collect(Collectors.toList());
    }
}
