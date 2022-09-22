package racing_car.step4.domain;

import racing_car.step4.dto.CarDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String NO_SUCH_WINNER = "우승자가 없습니다.";
    
    private final List<Car> cars;
    
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    
    public List<Car> tryMove(MoveStrategy moveStrategy) {
        return cars.stream()
                .map(car -> car.moveTry(moveStrategy))
                .collect(Collectors.toList());
    }
    
    public List<CarDTO> information() {
        return cars.stream()
                .map(Car::information)
                .collect(Collectors.toList());
    }
    
    public List<CarDTO> findWinners() {
        int maxPosition = getMaxPosition();
        
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::information)
                .collect(Collectors.toList());
    }
    
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.information().getPosition())
                .max()
                .orElseThrow(() -> {throw new UnsupportedOperationException(NO_SUCH_WINNER);});
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
