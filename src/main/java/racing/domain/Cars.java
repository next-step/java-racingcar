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
    private NumberGenerator movableNumberGenerator;
    private List<Car> cars;
    
    private Cars(Builder builder) {
        cars = builder.cars;
        movableNumberGenerator = builder.generator;
    }
    
    public static class Builder {
        private NumberGenerator generator;
        private List<Car> cars;
        
        public Builder(List<Car> cars) {
            this.cars = cars;
        }
        
        public Builder generator(NumberGenerator generator) {
            this.generator = generator;
            return this;
        }
        
        public Cars build() {
            return new Cars(this);
        }
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
    
    public Cars moveCars() {
        cars.stream()
            .filter(car -> movableNumberGenerator.getNumber() >= MIN_MOVABLE_NUMBER)
            .forEach(Car::forward);
        return this;
    }
    
    public Cars getWinner() {
        final List<Car> sortedPlayer = cars.stream()
          .sorted(getCarWinnerComparator())
          .collect(Collectors.toList());
        final int winnerPosition = sortedPlayer.get(LEADER_INDEX).getPosition();
        return new Cars.Builder(sortedPlayer.stream()
          .filter(car -> car.getPosition() == winnerPosition)
          .collect(Collectors.toList())).build();
    }
    
    private Comparator<Car> getCarWinnerComparator() {
        return Comparator.comparing(Car::getPosition).reversed();
    }
    
    public Cars getCopiedCars() {
        return new Cars.Builder(cars.stream()
          .map(car -> new Car(car.getName(), car.getPosition()))
          .collect(Collectors.toList())).build();
    }
}
