package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final List<RacingCar> racingCar = new ArrayList<>();
    private int matchCount;

    public RacingService(int carNumber, int matchCount) {
        this.matchCount = matchCount;
        for (int i = 0; i < carNumber; i++) {
            racingCar.add(new RacingCar());
        }
    }

    public boolean isMatching() {
        return matchCount > 0;
    }

    public void match() {
        if (matchCount > 0) {
            movingCars();
            matchCount--;
        }
    }

    private void movingCars() {
        for (RacingCar car : racingCar) {
            car.move(RandomMove.getInstance().movable());
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getRacingCarsStatus() {
        StringBuilder sb = new StringBuilder();
        for (RacingCar car : racingCar) {
            sb.append(car.getStatus());
            sb.append("\n");
        }
        return sb.toString();
    }
}
