package race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final String PRINT_EXECUTION_RESULT = "실행 결과";
    private final ResultView resultView = new ResultView();
    private List<RacingCar> racingCars;
    private int raceCount = 0;

    public void setRacingCars(List<String> carNames) {
        this.racingCars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            this.racingCars.add(new RacingCar(carNames.get(i)));
        }
    }

    public void race(List<RacingCar> racingCars) {
        System.out.println(PRINT_EXECUTION_RESULT);
        for (RacingCar car : racingCars) {
            car.moveForward();
        }
        resultView.printRaceCondition(racingCars);
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public void startRace() {
        IntStream.range(0, raceCount).forEach(i -> race(this.racingCars));
    }
}
