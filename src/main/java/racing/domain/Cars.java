package racing.domain;

import racing.common.RacingSettings;

import java.util.ArrayList;
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
            .reduce((name1, name2) -> 
                name1 += RacingSettings.CAR_NAME_SEPARATOR.getStr() + name2)
            .get();
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public void moveCars(int movableNumber) {
        cars.stream()
            .filter(car -> movableNumber > MIN_MOVABLE_NUMBER)
            .forEach(Car::forward);
    }
    
    public Cars getWinner() {
        List<Car> sortedPlayer = cars.stream().sorted(getCarWinnerComparator()).collect(Collectors.toList());
        int winnerPosition = sortedPlayer.get(LEADER_INDEX).getPosition();
        return new Cars(sortedPlayer.stream()
            .filter(car -> car.getPosition() == winnerPosition)
            .collect(Collectors.toList()));

    }
    
    private Comparator<Car> getCarWinnerComparator() {
        return Comparator.comparing(Car::getPosition).reversed();
    }
    
    public Cars getCopiedCars() {
        return new Cars(new ArrayList<>(cars));
    }
}
