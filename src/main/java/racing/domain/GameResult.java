package racing.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final Game game;
    private List<Round> roundList = new ArrayList<Round>();

    public GameResult(Game game) {
        this.game = game;
    }

    public void addRound(Round round) {
        this.roundList.add(round);
    }

    public String gameWinner() {
        return String.join(",", game.getCars().stream()
                .filter(car -> car.getForwardCount() == maximumDistance(getLastRound()))
                .map(car -> car.getCarName())
                .collect(Collectors.toList()));
    }

    private Round getLastRound() {
        return roundList.stream()
                .reduce((firstRound, lastRound) -> lastRound)
                .get();
    }

    private int maximumDistance(Round round) {
        return round.getForwardCountOfCars().stream()
                .max(Comparator.comparing(Integer::intValue))
                .get();
    }

    public List<Round> getGameRoundList() {
        return roundList;
    }
}