package racingcar;

import java.util.List;
import java.util.Random;

public class Stadium {
    private List<Car> cars;
    private int gameCount;

    public List<Car> playRace() {
        for (int i = 0; i < gameCount; i++){
            for (Car car : cars){
                int number = drawNumber();
                car.go(number);
                System.out.println(car.getName() + " : " + goingProcess(car));
            }
        }
        return cars;
    }

    public String goingProcess(Car car){
        StringBuilder process = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            process.append("-");
        }
        return process.toString();
    }

    public Stadium(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    private int drawNumber(){
        return new Random().nextInt(10);
    }
}
