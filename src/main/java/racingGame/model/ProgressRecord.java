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
    
    public List<Car> findWinners() {
        return findMaxCar(findMaxLocation());
    }
    
    private int findMaxLocation() {
        int max = Integer.MIN_VALUE;
        for(Car joinCar: joinCars) {
            max = Math.max(max, joinCar.findLocation());
        }
        return max;
    }
    
    private List<Car> findMaxCar(int max) {
        List<Car> winnerCars = new ArrayList<>();
        for(Car joinCar: joinCars) {
            if(max == joinCar.findLocation()) {
                winnerCars.add(joinCar);
            }
        }
        return winnerCars;
    }
    
}
