package racing;

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

    static class GameRoundResult {
        private final List<Integer> statusList = new ArrayList<>();

        public void prints() {
            for (Integer status : statusList) {
                IntStream.range(0, status)
                        .mapToObj(i -> "-")
                        .forEach(System.out::print);
                System.out.println();
            }
            System.out.println();
        }

        public void addResult(int status) {
            statusList.add(status);
        }
    }
}
