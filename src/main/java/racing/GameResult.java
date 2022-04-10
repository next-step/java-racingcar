package racing;

import racing.model.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameResult {
    private final List<GameRoundResult> rounds = new ArrayList<>();

    public void addRoundResult(GameRoundResult round) {
        rounds.add(round);
    }

    public void prints() {
        rounds.forEach(GameRoundResult::prints);
    }

    public static class GameRoundResult {
        private final List<Counter> statusList = new ArrayList<>();

        public void prints() {
            for (Counter status : statusList) {
                IntStream.range(0, status.getCount())
                        .mapToObj(i -> "-")
                        .forEach(System.out::print);
                System.out.println();
            }
            System.out.println();
        }

        public void addResult(Counter status) {
            statusList.add(status);
        }
    }
}
