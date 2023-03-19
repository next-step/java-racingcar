package racingcar_tdd.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners(int maxinumPosition) {
        final List<Car> winners = new ArrayList<>();

        for (final Car car : cars) {
            if (car.getPosition() == maxinumPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getMaximumPosition() {
        int maxinumPosition = 0;
        for (final Car car : cars) {
            maxinumPosition = Math.max(maxinumPosition, car.getPosition());
        }
        return maxinumPosition;
    }

    public List<Car> toList() {
        return cars;
    }

    public void printRace(){
        for(Car car: this.cars){
            int i=0;
            System.out.print(car.getName()+" : ");
            while(i<car.getPosition()){
                System.out.print("-");
                i++;
            };
            System.out.println("");
        }
    }
}
