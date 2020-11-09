package step5.service;

import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.GameRound;
import step5.dto.RacingGameConditionDTO;
import step5.exception.NotGameEndException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class RacingGame {


    private static final String SPLIT_SEPARATOR = ",";
    private static final String WINNER_DELIMITER = ",";

    private final Cars cars;
    private final RacingGameConditionDTO racingGameConditionDTO;

    private RacingGame(RacingGameConditionDTO racingGameConditionDTO) {
        this.racingGameConditionDTO = racingGameConditionDTO;

        cars = new Cars(splitToCarList(getRacingGameCarNames()));
    }

    public static RacingGame of(RacingGameConditionDTO racingGameConditionDTO) {
        return new RacingGame(racingGameConditionDTO);
    }

    public Cars runRound() {
        getGameRound().stackGameRound();

        cars.moveCars();

        return cars;
    }

    public boolean isGameEnd() {
        return racingGameConditionDTO
                .getGameRound()
                .isGameFinish();
    }

    public String getTopPositionCarNames() {
        validGameEnd();
        int topPosition = getTopPosition(cars.getCarList());
        return matchCarsTopPositionToName(topPosition);
    }

    private String matchCarsTopPositionToName(int topPosition) {
        return cars.getCarList()
                .stream()
                .filter(car -> car.getPosition() == topPosition)
                .map(Car::toString)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void validGameEnd() {
        if (!getGameRound().isGameFinish()) {
            throw new NotGameEndException();
        }
    }


    private List<Car> splitToCarList(String input) {
        return Arrays.stream(input.split(SPLIT_SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList());
    }


    private static Integer getTopPosition(List<Car> carList) {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }


    private String getRacingGameCarNames() {
        return racingGameConditionDTO
                .getCarNames();
    }

    private GameRound getGameRound() {
        return racingGameConditionDTO
                .getGameRound();
    }


}
