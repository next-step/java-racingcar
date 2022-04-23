package teacher.step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAX_BOUND = 10;
    private int tryNum;
    private List<Car> cars;

    public RacingGame(String carNames, int tryNo) {

    }

    public void race() {
        this.tryNum--;
        moveCars();
    }

    private void moveCars() {
        for (Car car: cars) {
            car.move(getRandomNum());
        }
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public boolean racing() {
        return this.tryNum > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        return null;
    }
}
