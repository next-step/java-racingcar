package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Rounds {

    private final List<Round> rounds = new ArrayList();

    public Rounds(int count){
        this.isZero(count);
        this.isNegative(count);

        for (int i = 0; i < count; i++) {
            rounds.add(new Round());
        }
    }

    private void isZero(int count){
        if(count == 0){
            throw new IllegalArgumentException("경기 수가 0일 수는 없습니다.");
        }
    }

    private void isNegative(int count){
        if(count < 0){
            throw new IllegalArgumentException("경기 수가 0보다 작을 수 없습니다.");
        }
    }

    public void play(Cars cars){
        ResultView.resultView();

        for (Round round : rounds) {
            round.play(cars);
            ResultView.breakLine();
        }
    }
}
