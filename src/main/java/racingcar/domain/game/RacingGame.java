package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCars;
import racingcar.domain.car.Winners;
import racingcar.domain.game.dto.CarDto;
import racingcar.domain.game.dto.CarsDto;
import racingcar.domain.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Trial numbOfTrial;
    private final RacingCars cars;

    public RacingGame(int numbOfTrial,
                      List<String> carNames,
                      RandomGenerator randomGenerator) {

        this.numbOfTrial = new Trial(numbOfTrial);
        this.cars = makeRacingCars(carNames, randomGenerator);
    }

    private RacingCars makeRacingCars(List<String> names,
                                      RandomGenerator randomGenerator) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return new RacingCars(cars, randomGenerator);
    }

    public CarsDto runOnce() {
        if (!numbOfTrial.hasChance()) {
            throw new GameException("이미 레이싱이 끝났습니다.");
        }
        numbOfTrial.decrease();
        moveCars();

        return convertToDTO(this.cars.all());
    }

    private void moveCars() {
        this.cars.moveCars();
    }

    public CarsDto winnerCars() {
        List<Car> winners = this.cars.findCarsAt(this.cars.maxLocation());

        return convertToDTO(winners);
    }

    private CarsDto convertToDTO(List<Car> cars) {
        return new CarsDto(cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList()));
    }

    public boolean isEnded() {
        return !this.numbOfTrial.hasChance();
    }
}
