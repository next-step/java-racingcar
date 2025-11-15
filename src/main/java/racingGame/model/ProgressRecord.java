package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public record ProgressRecord(List<Car> joinCars) {
    
    // ? 깊은 복사가 필요하게된 원인을 사전에 포착하기 위한 테스트 방법은?
    public ProgressRecord(List<Car> joinCars) {
        List<Car> cars = new ArrayList<>();
        for(Car joinCar: joinCars) {
            cars.add(new Car(joinCar.getName(), joinCar.findLocation()));
        }
        this.joinCars = cars;
    }
}
