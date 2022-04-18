package racingcar;

import java.security.SecureRandom;
import java.util.List;

public class RacingCar implements NumberGenerator {
    private List<Car> cars;
    private int round;
    private SecureRandom random = new SecureRandom();

    public RacingCar(List<Car> cars, int round) {
        this.cars = cars;
        this.setRound(round);
    }

    private void setRound(int round) {
        if(round < 0) {
            throw new IllegalArgumentException("round는 음수가 될 수 없습니다");
        }
        this.round = round;
    }

    public void playRound() {
        decreaseRound();
        for (Car car:cars) {
            car.play(generateNumber());
        }
    }

    private void decreaseRound() {
        if(round <= 0) {
            throw new IllegalStateException("모든 라운드가 종료 되었습니다.");
        }
        round = round - 1;
    }

    @Override
    public int generateNumber() {
        return this.random.nextInt(MAX +1);
    }
}
