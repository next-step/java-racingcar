package step4;

import java.util.Objects;

public class Round {

    private final int round;

    public Round(int round) {
        valid(round);
        this.round = round;
    }

    private void valid(int round) {
        if(round == 0) {
            throw new IllegalArgumentException();
        }
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