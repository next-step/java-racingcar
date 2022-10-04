package game.domain.game;

import java.util.Objects;

public class Round {

    public static String ROUND_BOUND_EXCEPTION = "Round는 음수 값을 가질 수 없습니다.";
    public int round;

    public Round(int round) {
        if(round < 0){
            throw new IllegalArgumentException(ROUND_BOUND_EXCEPTION);
        }
        this.round = round;
    }

    public Round(Round round) {
        this.round = round.getRound();
    }

    public int getRound(){
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
