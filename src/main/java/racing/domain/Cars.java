package racing.domain;

import racing.common.ErrorMessage;
import racing.common.NumberGenerator;
import racing.common.RacingSettings;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final static int MIN_MOVABLE_NUMBER = 4;
    private final static int LEADER_INDEX = 0;
    private List<Car> cars;
    
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    
    public String getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .reduce((name1, name2) -> name1 += RacingSettings.CAR_NAME_SEPARATOR.getStr() + name2)
            .orElseThrow(() -> new NullPointerException(ErrorMessage.HAVE_NO_CAR.getMessage()));
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public Cars moveCars(NumberGenerator generator) {
        cars.stream()
            .filter(car -> generator.getNumber() >= MIN_MOVABLE_NUMBER)
            .forEach(Car::forward);
        return this;
    }

    public Cars getWinner() {
        final List<Car> sortedPlayer = cars.stream()
            .sorted(getCarWinnerComparator())
            .collect(Collectors.toList());
        final int winnerPosition = sortedPlayer.get(LEADER_INDEX).getPosition();
        return new Cars(sortedPlayer.stream()
            .filter(car -> car.getPosition() == winnerPosition)
            .collect(Collectors.toList()));
    }

    private Comparator<Car> getCarWinnerComparator() {
        return Comparator.comparing(Car::getPosition).reversed();
    }

    public Cars getCopiedCars() {
        return new Cars(cars.stream()
            .map(car -> new Car(car.getName(), car.getPosition()))
            .collect(Collectors.toList()));
    }
}
