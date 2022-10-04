package game.domain;

import java.util.Objects;

public class Round {

    public int round;

    public Round(int round) {
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
