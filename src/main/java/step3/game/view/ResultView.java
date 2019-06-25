package step3.game.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step3.game.domain.Car;
import step3.game.domain.CarName;
import step3.game.domain.Cars;
import step3.game.dto.RacingGameResultModel;

public class ResultView {
    private final RacingGameResultModel racingGameResultModel;

    public ResultView(RacingGameResultModel racingGameResultModel) {
        this.racingGameResultModel = racingGameResultModel;
    }

    public void printRacingGameResult() {
        System.out.println("\n실행 결과");

        List<Cars> result = racingGameResultModel.getCars();
        result.stream()
              .flatMap(this::flatMapAndNextLine)
              .forEach(car -> System.out.println(car.getCarName().getName() + "\t: " + getMovingPosition(car.getPosition())));

        String winners = racingGameResultModel.getWinners()
                                              .getCars()
                                              .stream()
                                              .map(Car::getCarName)
                                              .map(CarName::getName)
                                              .collect(Collectors.joining(", "));
        System.out.println("\n" + winners + "가 최종 우승했습니다.");
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
