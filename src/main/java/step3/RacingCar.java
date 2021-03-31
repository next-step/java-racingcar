package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    
    private List<Car> cars;
    private int roundCount;
    
    public RacingCar(List<Car> cars) throws Exception {
        this.cars = cars;
    }
    
    public RacingCar(List<Car> cars, int roundCount) throws Exception {
        this.roundCount = roundCount;
        this.cars = cars;
    }

    public void setRound(int roundCount) {
        this.roundCount = roundCount;
    }
    
    public int getTotalRound() {
        return this.roundCount;
    }
    
    public int getTotalCarCount() {
        return this.cars.size();
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }
    
    public void raceSingleRound() {
        for( int cIndex = 0 ; cIndex < getTotalCarCount() ; cIndex++ ) {
            getCarByIndex(cIndex).move(RacingCondition.isMoveForward());
        }
    }
    
    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<Car>();

        int maxPosition = getMaxPosition();
        for( Car car : cars ) {
            if( maxPosition == car.getPosition() ) {
                winners.add(car);
            }
        }
        
        return winners;
    }
    
    public int getMaxPosition() {
        int maxPosition = 0;
        
        for( Car car : cars ) {
            maxPosition = maxPosition < car.getPosition() ? car.getPosition() : maxPosition;
        }
        
        return maxPosition;
    }
}    
