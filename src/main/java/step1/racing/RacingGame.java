package step1.racing;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private static final String CAR_INDICATOR = "-";
    private final RandomListGenerator randomListGenerator;
    private final PositionSetter positionSetter;
    private final int players;
    private final int playTimes;
    private final int boundary;

    private List<Integer> carPositions;

    public RacingGame(RandomListGenerator randomListGenerator, PositionSetter positionSetter, int players, int playTimes, int boundary) {
        this.randomListGenerator = randomListGenerator;
        this.positionSetter = positionSetter;
        this.carPositions = Preparation.initRacingGame(players);
        this.playTimes = playTimes;
        this.players = players;
        this.boundary = boundary;
    }

    public void move() {
        viewCurrentStatus();
        IntStream.range(0, playTimes)
                 .forEach(count -> {
                     carPositions = positionSetter.movePosition(carPositions, getGachaList());
                 });
        viewCurrentStatus();
    }

    private <T extends Number> List<T> getGachaList() {
        return randomListGenerator.gacha(players, boundary);
    }

    private void viewCurrentStatus() {
        CarPositionViewer.rendering(carPositions, CAR_INDICATOR);
    }

}
