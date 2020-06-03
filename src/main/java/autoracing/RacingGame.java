package autoracing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final int totalRounds;
    private final List<Car> participants;

    public RacingGame(int numberOfCars, int totalRounds, RacingRule rule) {
        this.totalRounds = totalRounds;
        this.participants = IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car(rule))
                .collect(Collectors.toList());
    }

    public static RacingGame createFromConsole(RacingRule rule) {
        InputView inputView = InputView.takeInput(System.in);
        return new RacingGame(inputView.getNumberOfCars(), inputView.getTotalRounds(), rule);
    }

    public void start() {
        for (int currentRounds = 0; currentRounds < totalRounds; currentRounds++) {
            participants.forEach(Car::race);
        }
    }

    public void replayResult() {
        ResultView resultView = new ResultView(participants, totalRounds, "-");
        resultView.show();
    }
}
