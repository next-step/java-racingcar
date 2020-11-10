package step5.service;

import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.GameRound;
import step5.dto.RacingGameConditionDTO;
import step5.exception.NotCompareIntegerException;
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

    private String getRacingGameCarNames() {
        return racingGameConditionDTO
                .getCarNames();
    }

    private List<Car> splitToCarList(String input) {
        return Arrays.stream(input.split(SPLIT_SEPARATOR))
                .map(Car::new)
                .collect(Collectors.toList());
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
    private GameRound getGameRound() {
        return racingGameConditionDTO
                .getGameRound();
    }

    public String getTopPositionCarNames() {
        validGameEnd();

        return matchCarsTopPositionToName(getTopPosition(cars.getCarList()));
    }
    private void validGameEnd() {
        if (!getGameRound().isGameFinish()) {
            throw new NotGameEndException();
        }
    }
    private static Integer getTopPosition(List<Car> carList) {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(NotCompareIntegerException::new);
    }

    private String matchCarsTopPositionToName(int topPosition) {
        return cars.getCarList()
                .stream()
                .filter(car -> car.getPosition() == topPosition)
                .map(Car::toString)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }




}
