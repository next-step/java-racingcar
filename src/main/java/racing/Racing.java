package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final RacingCars racingCars;
    private final int matchCount;
    private static final Random random = new Random();

    public Racing(int carCount, int matchCount) {
        this.racingCars = this.racingCarRegistration(carCount);
        this.matchCount = matchCount;
    }

    private RacingCars racingCarRegistration(int carCount) {
        final List<Car> racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new Car());
        }

        return new RacingCars(racingCars);
    }

    /**
     * 스코어보드라는 상태를 가지지않고 바로 반환하게 구현했습니다.
     */
    public List<List<Integer>> race() {
        final List<List<Integer>> scoreBoard = new ArrayList<>();

        for (int i = 0; i < this.matchCount; i++) {
            this.carMove();
            scoreBoard.add(this.racingCars.carScore());
        }

        return scoreBoard;
    }

    private void carMove() {
        this.racingCars.carMove(random);
    }
}