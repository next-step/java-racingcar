package racing.board;

import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameResult {

    private final List<GameResultOfStepByStep> steps;

    public GameResult() {
        steps = new ArrayList<>();
    }

    int addStep(List<RacingCar> cars) {
        steps.add(new GameResultOfStepByStep(cars.stream()
                .map(RacingCar::mapToDto)
                .collect(Collectors.toList())));
        return steps.size();
    }

    public List<String> winners() {
        GameResultOfStepByStep lastStep = steps.get(steps.size() - 1);
        final int maxPosition = lastStep.getMaxPosition();

        return lastStep.stream()
                .filter(carDto -> carDto.getPosition() == maxPosition)
                .map(carDto -> carDto.getName())
                .collect(Collectors.toList());
    }

    public Stream<GameResultOfStepByStep> stream() {
        return steps.stream();
    }
}
