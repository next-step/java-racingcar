package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public record ProgressRecord(List<Car> joinCars) {
    
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
