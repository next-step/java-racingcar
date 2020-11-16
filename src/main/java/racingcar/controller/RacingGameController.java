package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.CarDTO;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameController {
    private static final int ZERO = 0;
    private RacingGame racingGame;

    public RacingGameController() {
        this.racingGame = new RacingGame();
    }

    public void createRacingCars(String carNames) {
        racingGame.createCars(carNames);
    }

    public Map<Integer, List<CarDTO>>  race(int repeatCount) {
        if (repeatCount < ZERO) {
            throw new IllegalArgumentException("1 이상의 숫자가 필요합니다.");
        }

        Map<Integer, List<CarDTO>> racingResult = new HashMap<>();
        for (int count = 0; count < repeatCount; count++) {
            List<Car> cars = racingGame.race();
            racingResult.put(count, toDTO(cars));
        }

        return racingResult;
    }

    public List<CarDTO> findWinner() {
        List<Car> winners = racingGame.findWinner();
        return toDTO(winners);

    }

    private List<CarDTO> toDTO(List<Car> cars) {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : cars) {
            carDTOS.add(new CarDTO(car));
        }
        return carDTOS;
    }
}
