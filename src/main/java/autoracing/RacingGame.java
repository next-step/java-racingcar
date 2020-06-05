package autoracing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final int totalRounds;
    private final List<Car> participants;

    public RacingGame(List<String> carNames, int totalRounds, RacingRule rule) {
        this.totalRounds = totalRounds;
        this.participants = carNames.stream()
                .map(name -> new Car(rule))
                .collect(Collectors.toList());
    }

    public static RacingGame createFromConsole(RacingRule rule) {
        InputView inputView = InputView.takeInput(System.in);
        return new RacingGame(inputView.getCarNames(), inputView.getTotalRounds(), rule);
    }

    public void start() {
        for (int currentRounds = 0; currentRounds < totalRounds; currentRounds++) {
            participants.forEach(Car::race);
        }
    }

    public void replayResult() {
        ResultView resultView = new ResultView(participants, totalRounds, "-", "실행 결과");
        resultView.show();
    }
}
