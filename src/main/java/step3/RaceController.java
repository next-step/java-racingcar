package step3;

import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceController {
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final int ZERO = 0;
    private Race race;

    public RaceController() {
        setupRace();
    }

    public void gameStart() {
        List<Record> records = race.start();

        RESULT_VIEW.renderResultMessage();
        RESULT_VIEW.renderRaceResult(records);
    }

    private void setupRace() {
        Count carCount = INPUT_VIEW.registerCar();
        Count trialCount = INPUT_VIEW.registerTrialCount();

        race = new Race();
        race.ready(new RacingCarGroup(newCarList(carCount)), trialCount);
    }

    private List<Car> newCarList(Count carCount) {
        RacingManager racingManager = new RandomManager();

        List<Car> cars = IntStream.range(ZERO, carCount.getCount())
                .mapToObj(i -> new Car(racingManager))
                .collect(Collectors.toList());

        return cars;
    }
}
