package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrandPrix {
    private int currentRound;
    private final List<Round> rounds;

    public GrandPrix(int totalRound) {
        this.currentRound = 0;
        this.rounds = IntStream.range(0, totalRound)
                .mapToObj(i -> new Round())
                .collect(Collectors.toList());
    }

    public boolean isFinished() {
        return rounds.stream()
                .allMatch(Round::isFinished);
    }

    public void play() {
        rounds.get(currentRound).play();
        currentRound++;
    }

    static class Round {
        private boolean finished;

        void play() {
            finished = true;
        }

        boolean isFinished() {
            return finished;
        }
    }
}
