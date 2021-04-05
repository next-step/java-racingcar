package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    
    private Cars cars;
    
    public RacingCar(Cars cars) throws Exception {
        this.cars = cars;
    }
    
    public int getTotalCarCount() {
        return this.cars.size();
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }
    
    public List<Boolean> getRacingCarMoveConditions() {
        List<Boolean> moveConditions = new ArrayList<Boolean>();
        for( int cIndex = 0 ; cIndex < getTotalCarCount() ; cIndex++ ) {
            moveConditions.add(RacingCondition.isMoveForward());
        }
        return moveConditions;
    }
    
    public void raceSingleRound(List<Boolean> moveCondition) {
        for( int cIndex = 0 ; cIndex < moveCondition.size() ; cIndex++ ) {
            getCarByIndex(cIndex).move(moveCondition.get(cIndex));
        }
    }
    
    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<Car>();

        int maxPosition = getMaxPosition();
        for( int index = 0 ; index < cars.size() ; index++ ) {
            if( cars.get(index).isEqualPosition(maxPosition) ) {
                winners.add(cars.get(index));
            }
        }
        
        return winners;
    }
    
    public int getMaxPosition() {
        int maxPosition = 0;

        for( int index = 0 ; index < cars.size() ; index++ ) {
            maxPosition = Math.max(cars.get(index).getPosition(), maxPosition);
        }
        
        return maxPosition;
    }
}    
