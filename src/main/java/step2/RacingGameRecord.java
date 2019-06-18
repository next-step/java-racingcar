package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRecord {
    private final List<Cars> result;

    public RacingGameRecord(List<Cars> result) {
        this.result = result;
    }

    public static RacingGameRecord newGame(Cars cars) {
        List<Cars> result = new ArrayList<>();
        result.add(cars);

        return new RacingGameRecord(result);
    }

    public void record(Cars cars) {
        if (cars.getCars().size() == 0) {
            throw new IllegalArgumentException("경주 자동차가 없습니다.");
        }
        this.result.add(cars);
    }

    public List<Cars> getResult() {
        return result;
    }

    public Cars previousTurn(int previousTurnNo) {
        if (previousTurnNo < 0) {
            throw new IllegalArgumentException("previousTurnNo 는 0 이상의 index 값입니다.");
        }
        if (previousTurnNo > result.size()) {
            throw new IndexOutOfBoundsException("현재 " + result.size() + " 턴 까지 실행되었습니다. 입력 값 : " + previousTurnNo);
        }

        return result.get(previousTurnNo);
    }
}
