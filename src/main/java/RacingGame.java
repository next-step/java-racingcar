import java.util.ArrayList;

public class RacingGame {

    private final RacingCarMovingRule racingCarMovingRule;

    public RacingGame(RacingCarMovingRule racingCarMovingRule) {
        this.racingCarMovingRule = racingCarMovingRule;
    }

    public RacingGame() {
        this(new RandomRacingCarMovingRule());
    }

    public ArrayList<RacingStep> run(int numCars, int numSteps) {
        ArrayList<RacingStep> racingStepList = new ArrayList<>();
        ArrayList<RacingCar> racingCarList = new ArrayList<>();

        for (int carId = 0; carId < numCars; carId++) {
            racingCarList.add(new RacingCar(racingCarMovingRule, carId));
        }

        racingStepList.add(new RacingStep(racingCarList));

        for (int step = 0; step < numSteps - 1; step++) {
            racingCarList.stream()
                    .forEach(racingCar -> racingCar.forward());

            racingStepList.add(new RacingStep(racingCarList));
        }

        return racingStepList;
    }

}
