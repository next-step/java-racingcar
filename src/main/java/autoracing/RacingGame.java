package autoracing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final int totalRounds;
    private final List<Car> participants;

    public RacingGame(int totalRounds, List<Car> participants) {
        this.totalRounds = totalRounds;
        this.participants = participants;
    }

    public static RacingGame createFromConsole(RacingRule rule) {
        InputView inputView = InputView.takeInput(System.in);
        RacingGame newGame = new RacingGame(inputView.getTotalRounds(), inputView.getCars());
        newGame.setRule(rule);
        return newGame;
    }

    public void setRule(RacingRule rule) {
        participants.forEach(participant -> participant.setRule(rule));
    }

    public void start() {
        for (int currentRounds = 0; currentRounds < totalRounds; currentRounds++) {
            participants.forEach(Car::race);
        }
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void replayResult() {
        ResultView resultView = new ResultView(this, "-", "실행 결과");
        resultView.show();
    }

    public List<Car> getWinners() {
        int winnerDistance = getWinnerDistance();
        return participants.stream()
                .filter((car) -> car.getLocation(totalRounds).getDistance() == winnerDistance)
                .collect(Collectors.toList());
    }

    private int getWinnerDistance() {
        Car oneOfWinner = participants.stream()
                .max(Comparator.comparingInt(a -> a.getLocation(totalRounds).getDistance()))
                .orElseThrow(() -> new IllegalArgumentException(""));
        return oneOfWinner.getLocation(totalRounds).getDistance();
    }
}
