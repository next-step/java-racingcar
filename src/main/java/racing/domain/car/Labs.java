package racing.domain.car;

import racing.domain.car.exception.UnderOfZeroException;
import racing.domain.score.History;

public class Labs {

    private final int labs;

    public Labs(int labs) {
        validation(labs);
        this.labs = labs;
    }

    private void validation(int labs) {
        if (labs < 0) {
            throw new UnderOfZeroException("0 미만은 입력할 수 없습니다.");
        }
    }


    public Track racing(History history, Cars cars) {
        Cars current = cars;
        History saveHistory = history;
        for (int i = 0; i < labs; i++) {
            current = current.move();
            saveHistory = saveHistory.save(current);
        }

        return new Track(saveHistory, current);
    }
}
