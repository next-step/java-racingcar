package racing.board;

import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<StepResult> history;

    public GameResult() {
        history = new ArrayList<>();
    }

    int addStep(List<RacingCar> cars) {
        history.add(new StepResult(cars));
        return history.size();
    }

    public List<StepResult> getHistory() {
        return history;
    }

    public List<RacingCar> getWinners() {
        if (history.size() == 0) {
            return Collections.emptyList();
        }

        StepResult lastStep = history.get(history.size() - 1);
        RacingCar mostFarPositionedCar = Collections.max(lastStep.getCars());

        return lastStep.getCars()
                .stream()
                .filter(car -> car.compareTo(mostFarPositionedCar) == 0)
                .collect(Collectors.toList());
    }
}
