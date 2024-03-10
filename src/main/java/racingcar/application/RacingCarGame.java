package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.CarMoveGenerator;
import racingcar.domain.Cars;
import racingcar.domain.dto.RacingCarRequest;
import racingcar.domain.dto.RacingCarResult;
import racingcar.domain.vo.NumberOfCars;
import racingcar.domain.vo.NumberOfTrials;
import racingcar.presentation.RacingCarClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final RacingCarClient racingCarClient;
    private final CarMoveGenerator carMoveGenerator;

    public RacingCarGame(final RacingCarClient racingCarClient, final CarMoveGenerator carMoveGenerator) {
        this.racingCarClient = racingCarClient;
        this.carMoveGenerator = carMoveGenerator;
    }

    public void play() {
        final RacingCarRequest racingCarInput = racingCarClient.getRacingCarInput();
        final Cars cars = createCars(racingCarInput);

        final NumberOfTrials numberOfTrials = racingCarInput.getNumberOfTrials();

        racingCarClient.showResultHeader();
        playRounds(numberOfTrials, cars);
    }

    private Cars createCars(final RacingCarRequest racingCarRequest) {
        final NumberOfCars numberOfCars = racingCarRequest.getNumberOfCars();
        final List<Car> car = createCar(numberOfCars.getValue());

        return new Cars(car);
    }

    private List<Car> createCar(final int value) {
        return IntStream.rangeClosed(1, value)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void playRounds(final NumberOfTrials numberOfTrials, final Cars cars) {
        for (int i = 0; i < numberOfTrials.getValue(); i++) {
            cars.tryAdvance(this.carMoveGenerator);
            final RacingCarResult racingCarResult = new RacingCarResult(cars.getCars());
            racingCarClient.showRacingCarResult(racingCarResult);
        }
    }
}
