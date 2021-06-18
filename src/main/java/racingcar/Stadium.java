package racingcar;

import java.util.List;
import java.util.Random;

public class Stadium {
    private static final int MOVING_STANDARD_VALUE = 4;
    private final List<Car> cars;
    private final int gameCount;

    public Stadium(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void playRace() {
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < gameCount; i++){
            for (Car car : cars){
                car.go(isMovable());
                System.out.println(car.getName() + " : " + goingProcess(car));
            }
            System.out.println();
        }
    }

    private String goingProcess(Car car){
        StringBuilder process = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            process.append("-");
        }
        return process.toString();
    }

    private boolean isMovable(){
        int number = new Random().nextInt(10);
        return number >= MOVING_STANDARD_VALUE;
    }

    public List<Car> getCars() {
        return cars;
    }
}
