package racing.domain;

import static racing.common.RacingSettings.*;
import racing.common.RandomNumberGenerator;
import racing.vo.Car;
import racing.vo.Cars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private Cars cars;
    private RandomNumberGenerator randomGenerator;
    
    public RacingManager(Cars cars) {
        this.cars = cars;
    }
    
    public RacingManager(String carNames) {
        this.cars = new Cars(Arrays.stream(carNames.split(","))
          .map(Car::new)
          .collect(Collectors.toList())
        );
        randomGenerator = new RandomNumberGenerator(MAX_RANDOM_MOVABLE_NUMBER.getValue());
    }
    
    public void moveCars() {
        cars.getCars().stream()
          .filter(car -> randomGenerator.getNumber() > MIN_MOVABLE_NUMBER.getValue())
          .forEach(Car::forward);
    }
    
    public Cars getWinners() {
        List<Car> players = cars.getCars().stream()
            .sorted(getCarWinnerComparator())
            .collect(Collectors.toList());
        int winnerPosition = players.get(LEADER_INDEX.getValue()).getPosition();
        return new Cars(players.stream()
            .filter(car -> car.getPosition() == winnerPosition)
            .collect(Collectors.toList())); 
    }
    
    private Comparator<Car> getCarWinnerComparator() {
        return Comparator.comparing(Car::getPosition).reversed();
    }
    
    public Cars getCars() {
        return cars;
    }
    
}
