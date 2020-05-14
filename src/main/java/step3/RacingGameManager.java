package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameManager {

    private final int gameRound;
    private final List<RacingCar> racingCarList;

    private int progressRound;
    private List<Integer> carPositions;

    public RacingGameManager(int carCount, int gameRound) {
        this.gameRound = gameRound;
        this.racingCarList = IntStream.range(0, carCount)
                .mapToObj(RacingCar::create)
                .collect(Collectors.toList());
    }

    public static RacingGameManager start(int carCount, int gameRound) {
        return new RacingGameManager(carCount, gameRound);
    }

    public void nextRound() {
        if (!this.hasNextRound()) {
            throw new IllegalStateException("진행 할 라운드가 없습니다.");
        }

        this.progressRound++;
        this.carPositions = this.racingCarList.stream()
                .map(racingCar -> racingCar.move(RandomMoveFactory.getInstance()))
                .collect(Collectors.toList());
    }

    public boolean hasNextRound() {
        return this.progressRound < this.gameRound;
    }

    public List<Integer> getCarPosition() {
        return this.carPositions;
    }
}
