package racinggame.domain;

import racinggame.dto.RacingInputDTO;
import racinggame.dto.RacingResultDTO;
import racinggame.dto.RacingRoundResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public RacingResultDTO start(RacingInputDTO racingInputDTO) {

        List<Car> carList = new ArrayList<>();
        List<RacingRoundResultDTO> racingRoundResultDTOS = new ArrayList<>();

        createCars(carList, racingInputDTO);

        for (int round = 1; round <= racingInputDTO.getGameCount(); round++) {
            racingRoundResultDTOS.add(new RacingRoundResultDTO(round,carMove(carList)));
        }

        Winner winner = new Winner(carList);
        return new RacingResultDTO(carList, winner.getWinners(), racingRoundResultDTOS);
    }

    private List<Car> carMove(List<Car> carList) {
        List<Car> roundCarState = new ArrayList<>();
        for (Car car : carList) {
            car.move(random.nextInt(RANDOM_BOUND));
            roundCarState.add(new Car(car.getCarName(), car.getPosition()));
        }
        return roundCarState;
    }

    private void createCars(List<Car> carList, RacingInputDTO racingInputDTO) {
        for (String carName : racingInputDTO.getCarNames()) {
            carList.add(new Car(carName));
        }
    }
}
