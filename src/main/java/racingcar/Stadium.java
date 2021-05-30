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

    public String winnerIS(List<Car> result) {
        StringBuilder winnerIS = new StringBuilder();
        for(Car car : result) {
            winnerIS.append(car.getName() + ",");
        }
        winnerIS.deleteCharAt(winnerIS.lastIndexOf(","));
        return winnerIS.toString();
    }



    public List<Car> award() {
        List<Car> result = new ArrayList<>();
        int maxPosition = findMaxPosition();
        for (Car car : cars) {
            if (car.isInPosition(maxPosition)) {
                result.add(car);
                System.out.println();
            }
        }
        return result;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = car.whichOneIsBiggerThan(maxPosition);
        }
        return maxPosition;
    }

    public void playRace() {
        for (int i = 0; i < gameCount; i++){
            for (Car car : cars){
                car.go(drawNumber());
                System.out.println(car.getName() + " : " + goingProcess(car));
            }
        }
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
