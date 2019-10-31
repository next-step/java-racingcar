package step1.racing;

import java.util.List;
import java.util.stream.IntStream;

import step1.racing.data.RacingCar;
import step1.racing.view.CarPositionViewer;

public class RacingGame {
    private static final String CAR_INDICATOR = "-";
    private final RandomListGenerator randomListGenerator;
    private final PositionSetter positionSetter;
    private final int playTimes;
    private final int boundary;

    private List<RacingCar> carPositions;

    public RacingGame(RandomListGenerator randomListGenerator, PositionSetter positionSetter, List<RacingCar> carPositions, int playTimes, int boundary) {
        this.randomListGenerator = randomListGenerator;
        this.positionSetter = positionSetter;
        this.carPositions = carPositions;
        this.playTimes = playTimes;
        this.boundary = boundary;
    }

    public void move() {
        viewCurrentStatus();
        IntStream.range(0, playTimes)
                 .forEach(count -> positionSetter.movePosition(carPositions, getGachaList()));
        viewCurrentStatus();
    }

    private <T extends Number> List<T> getGachaList() {
        return randomListGenerator.gacha(carPositions.size(), boundary);
    }

    private void viewCurrentStatus() {
        CarPositionViewer.rendering(carPositions, CAR_INDICATOR);
    }

}
