package step1.racing;

import java.util.List;

public class RacingGame {
    private static final String CAR_INDICATOR = "-";
    private final RandomListGenerator randomListGenerator;
    private final PositionSetter positionSetter;
    private final int playTimes;
    private final int boundary;

    private List<Integer> carPositions;

    public RacingGame(RandomListGenerator randomListGenerator, PositionSetter positionSetter, int players, int playTimes, int boundary) {
        this.randomListGenerator = randomListGenerator;
        this.positionSetter = positionSetter;
        this.carPositions = Preparation.initRacingGame(players);
        this.playTimes = playTimes;
        this.boundary = boundary;
    }

    public void move() {
        viewCurrentStatus();
        carPositions = positionSetter.movePosition(carPositions, getGachaList(playTimes, boundary));
        viewCurrentStatus();
    }

    private <T extends Number> List<T> getGachaList(int playTimes, int boundary) {
        return randomListGenerator.gacha(playTimes, boundary);
    }

    private void viewCurrentStatus() {
        CarPositionViewer.rendering(carPositions, CAR_INDICATOR);
    }

}
