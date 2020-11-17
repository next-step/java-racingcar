import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private ArrayList<RacingStep> racingStepList;

    public RacingResult(ArrayList<RacingStep> racingStepList) {
        this.racingStepList = racingStepList;
    }

    public ArrayList<RacingStep> getRacingStepList() {
        return racingStepList;
    }

    public List<String> getWinnerNames() {
        if (racingStepList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        RacingStep lastRacingStep = racingStepList.get(racingStepList.size() - 1);

        int winnerPosition = lastRacingStep.getWinnerPosition();

        List<String> winnerNames = lastRacingStep.getCarNameAndPositionList().stream()
                .filter(nameAndPosition -> nameAndPosition.getPosition() == winnerPosition)
                .map(nameAndPosition -> nameAndPosition.getName())
                .collect(Collectors.toList());

        return winnerNames;
    }

}
