package racingCar;

import java.security.SecureRandom;
import java.util.List;

public class RacingCar implements NumberGenerator {
    private List<Car> cars;
    private int round;
    private SecureRandom random;

    public RacingCar(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
        this.random = new SecureRandom();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getRound() {
        return this.round;
    }

    public void playRacing() {
        for (int currentRound = 0; currentRound < round; currentRound++) {
            for (Car car:cars) {
                car.play(this.generateNumber());
            }
        }
    }

    @Override
    public int generateNumber() {
        return this.random.nextInt(MAX +1);
    }
}
