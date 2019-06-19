package racing.domain;

import racing.common.RacingSettings;
import racing.common.RandomNumberGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final static int MIN_MOVABLE_NUMBER = 4;
    private final static int LEADER_INDEX = 0;
    private final static int MAX_RANDOM_MOVABLE_NUMBER = 9;
    private RandomNumberGenerator randomGenerator;
    private List<Car> cars;
    
    
    public Cars(List<Car> cars) {
        this.cars = cars;
        randomGenerator = new RandomNumberGenerator(MAX_RANDOM_MOVABLE_NUMBER);
    }
    
    public String getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .reduce((name1, name2) -> 
                name1 += RacingSettings.CAR_NAME_SEPARATOR.getStr() + name2)
            .get();
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public void moveCars() {
        cars.stream()
            .filter(car -> randomGenerator.getNumber() > MIN_MOVABLE_NUMBER)
            .forEach(Car::forward);
    }
    
    public Cars getWinner() {
        List<Car> sortedPlayer = cars.stream()
            .sorted(getCarWinnerComparator())
            .collect(Collectors.toList());
        int winnerPosition = sortedPlayer.get(LEADER_INDEX).getPosition();
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
