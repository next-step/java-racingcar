package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGameInfo;
import racing.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

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
        resultView.printWinner(getWinners(cars));
    }

    private void play(Cars cars) {
        cars.moveEvent();
        resultView.result(cars);
    }

    private List<Car> getWinners(Cars cars) {
        Set<Map.Entry<Integer, List<Car>>> groupCars = cars.getCars().stream()
                .collect(groupingBy(Car::getDistance))
                .entrySet();

        return groupCars.stream().max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }
}