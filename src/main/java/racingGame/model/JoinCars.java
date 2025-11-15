package racingGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record JoinCars(List<Car> cars) {
    
    public JoinCars {
        cars = new ArrayList<>(cars);
    }
    
    public JoinCars() {
        this(List.of());
    }
    
    public void addJoinCars(Car car) {
        this.cars.add(car);
    }
    
    public JoinCars findWinners() {
        return findMaxCar(findMaxLocation());
    }
    
    private int findMaxLocation() {
        int max = Integer.MIN_VALUE;
        for(Car joinCar: this.cars) {
            max = Math.max(max, joinCar.findLocation());
        }
        return max;
    }
    
    private JoinCars findMaxCar(int max) {
        List<Car> winnerCars = new ArrayList<>();
        for(Car joinCar: this.cars) {
            if(max == joinCar.findLocation()) {
                winnerCars.add(joinCar);
            }
        }
        return new JoinCars(winnerCars);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        JoinCars joinCars = (JoinCars) o;
        return Objects.equals(cars, joinCars.cars);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
    
}
