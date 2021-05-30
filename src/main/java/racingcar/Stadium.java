package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stadium {
    private final List<Car> cars;
    private final int gameCount;

    public Stadium(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public List<Car> award() {
        List<Car> winner = new ArrayList<>();
        int maxPosition = findMaxPosition();
        for (Car car : cars) {
            if (car.isInPosition(maxPosition)) {
                winner.add(car);
            }
        }
        return winner;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = car.whichOneIsBiggerThan(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> playRace() {
        for (int i = 0; i < gameCount; i++){
            for (Car car : cars){
                car.go(drawNumber());
                System.out.println(car.getName() + " : " + goingProcess(car));
            }
        }
        return cars;
    }

    private String goingProcess(Car car){
        StringBuilder process = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            process.append("-");
        }
        return process.toString();
    }

    private int drawNumber(){
        return new Random().nextInt(10);
    }
}
