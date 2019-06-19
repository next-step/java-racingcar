package step2.game.ui;

import java.util.List;
import java.util.stream.Stream;

import step2.game.dto.RacingGameResultModel;
import step2.game.domain.Car;
import step2.game.domain.Cars;

public class ResultView {
    private final RacingGameResultModel racingGameResultModel;

    public ResultView(RacingGameResultModel racingGameResultModel) {
        this.racingGameResultModel = racingGameResultModel;
    }

    public void printRacingGameResult() {
        List<Cars> result = racingGameResultModel.getCars();
        result.stream()
              .flatMap(this::flatMapAndNextLine)
              .forEach(car -> System.out.println(" => " + getMovingPosition(car.getPosition())));
    }

    private Stream<Car> flatMapAndNextLine(Cars cars) {
        System.out.println();
        return cars.getCars().stream();
    }

    private String getMovingPosition(Integer position) {
        String movingPosition = "";
        for (int i = 0; i < position; i++) {
            movingPosition += "-";
        }
        return movingPosition;
    }
}
