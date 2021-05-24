package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    public final int moveNumber = 9;
    public Random random = new Random();

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
            for (Car car : cars.getRacingCars()) {
                int number = createRandomNumber();
                car.moveOrNot(number);
                System.out.println(car.getCarName() + " : " + this.advance(car.getPosition()));
            }
            System.out.println();
        }
    }

    public List<String> victor(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.maxPosition(maxPosition)) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

}
