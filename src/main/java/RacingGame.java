import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RacingCarMovingRule racingCarMovingRule;

    public RacingGame(RacingCarMovingRule racingCarMovingRule) {
        this.racingCarMovingRule = racingCarMovingRule;
    }

    public ArrayList<RacingStep> run(List<String> carNameList, int numSteps) {
        ArrayList<RacingCar> racingCarList = buildRacingCarList(carNameList);
        ArrayList<RacingStep> racingStepList = new ArrayList<>();

        racingStepList.add(new RacingStep(racingCarList));

        for (int step = 0; step < numSteps - 1; step++) {
            racingCarList.forEach(racingCar -> racingCar.forward());

            racingStepList.add(new RacingStep(racingCarList));
        }

        return racingStepList;
    }

    private ArrayList<RacingCar> buildRacingCarList(List<String> carNameList) {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();

        for (String carName : carNameList) {
            racingCarList.add(new RacingCar(carName, racingCarMovingRule));
        }

        return racingCarList;
    }

    public static List<String> getWinnerNames(ArrayList<RacingStep> racingStepList) {
        if (racingStepList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        RacingStep lastRacingStep = racingStepList.get(racingStepList.size() - 1);

        int winnerPosition = getWinnerPosition(lastRacingStep);

        List<String> winnerNames = lastRacingStep.getCarNameAndPositionList().stream()
                .filter(nameAndPosition -> nameAndPosition.getPosition() == winnerPosition)
                .map(nameAndPosition -> nameAndPosition.getName())
                .collect(Collectors.toList());

        return winnerNames;
    }

    private static int getWinnerPosition(RacingStep lastRacingStep) {
        return lastRacingStep.getCarNameAndPositionList().stream()
                    .mapToInt(nameAndPosition -> nameAndPosition.getPosition())
                    .max()
                    .getAsInt();
    }

}
