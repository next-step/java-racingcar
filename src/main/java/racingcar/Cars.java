package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;
    private final int MOVE_NUMBER = 9;

    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(MOVE_NUMBER);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String move(int position) {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar = bar.concat("-");
        }
        return bar;
    }

    public void moveCars(int count) {
        for (Car car : cars) {
            int number = createRandomNumber();
            car.moveOrNot(number);
            System.out.println(car.getCarName() + " : " + this.move(car.getPosition()));
        }
    }

    public int maxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.biggestPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> win(int max) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.maxCheck(max)) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }
}
