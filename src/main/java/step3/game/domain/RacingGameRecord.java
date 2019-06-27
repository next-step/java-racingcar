package step3.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameRecord {
    private final List<Cars> result;

    private RacingGameRecord(List<Cars> result) {
        this.result = result;
    }

    public static RacingGameRecord newGame(Cars cars) {
        List<Cars> result = new ArrayList<>();
        result.add(cars);

        return new RacingGameRecord(result);
    }

    public void record(Cars cars) {
        this.result.add(cars);
    }

    public List<Cars> getResult() {
        return result.stream()
                     .map(Cars::new)
                     .collect(Collectors.toList());
    }

    public Cars previousTurn(int previousTurnNo) {
        assertTurnNo(previousTurnNo, result.size());
        return result.get(previousTurnNo);
    }

    public Cars winners() {
        final int beforeTurnNo = result.size() - 1;

        Cars finalTurn = result.get(beforeTurnNo);
        return finalTurn.winners();
    }

    private void assertTurnNo(final int previousTurnNo, final int resultSize) {
        if (previousTurnNo < 0) {
            throw new IllegalArgumentException("previousTurnNo 는 0 이상의 index 값입니다.");
        }

        if (previousTurnNo >= resultSize) {
            throw new IndexOutOfBoundsException("현재 " + resultSize + " 턴 까지 실행되었습니다. 입력 값 : " + previousTurnNo);
        }
    }
}
