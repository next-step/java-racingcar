package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    Random random = new Random();
    private final int moveNumber = 9;

    public int createRandomNumber() {
        return random.nextInt(moveNumber);
    }

    public String advance(int position) {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar = bar.concat("-");
        }
        return bar;
    }

    public void startRacing(int count, Cars cars) {
        for (int i = 0; i < count; i++) {
            for (Car car : cars.getCars()) {
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.advance(car.getPosition()));
            }
            System.out.println();
        }
    }
    public int maxPosition(List<Car> cars){
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> victor(List<Car> cars) {
        int max = maxPosition(cars);
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.maxCheck(max)) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }
}
