package racing.domain;

import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.util.StringSplitter;
import racing.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public Cars(String carNamesString) {
        this(createCars(carNamesString));
    }

    private static List<Car> createCars(String carNamesString) {
        Validator.validateCarNames(carNamesString);
        List<String> carNames = StringSplitter.getNameList(carNamesString);
        return carNames.stream()
                .filter(carName -> !carName.isBlank())
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(){
        cars.forEach(car ->
                car.move(numberGenerator.generate()));
    }

    public List<Car> cars() {
        return cars;
    }

    public Winners findWinners() {
        Winners winners = new Winners();
        cars.stream()
                .filter(car -> car.isWinner(maxPosition()))
                .forEach(winners::addWinner);
        return winners;
    }

    private Position maxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars)
            maxPosition = car.getMaxPosition(maxPosition);

        return maxPosition;
    }
}
