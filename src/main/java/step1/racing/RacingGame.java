package step1.racing;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final RandomListGenerator randomListGenerator;
    private final PositionSetter positionSetter;
    private final RacingCarHandler carPositions;
    private final int playTimes;
    private final int boundary;


    public RacingGame(RandomListGenerator randomListGenerator, PositionSetter positionSetter, RacingCarHandler carPositions, int playTimes, int boundary) {
        this.randomListGenerator = randomListGenerator;
        this.positionSetter = positionSetter;
        this.carPositions = carPositions;
        this.playTimes = playTimes;
        this.boundary = boundary;
    }

    public void move() {
        IntStream.range(0, playTimes)
                 .forEach(count -> positionSetter.movePosition(carPositions, getGachaList()));
    }

    private <T extends Number> List<T> getGachaList() {
        return randomListGenerator.gacha(carPositions.size(), boundary);
    }
}
