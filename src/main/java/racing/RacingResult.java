package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<Car> cars;
    private int maxCarPosition;

    public RacingResult(List<Car> cars){
        this.cars = cars;
        this.maxCarPosition = getWinnerPosition();
    }

    public RacingResult(List<Car> cars, int maxCarPosition){
        this.cars = cars;
        this.maxCarPosition = maxCarPosition;
    }

    public int getWinnerPosition(){
        maxCarPosition = cars.get(0).getPosition();
        for(Car car:cars){
            maxCarPosition = (car.getPosition() > maxCarPosition) ? car.getPosition() : maxCarPosition;
        }
        return maxCarPosition;
    }

    public List<Car> getWinners(int maxCarPosition){
        List<Car> winners = new ArrayList<Car>();
        for(Car car:cars){
            if(car.getPosition() == maxCarPosition) { winners.add(car); }
        }
        return winners;
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
