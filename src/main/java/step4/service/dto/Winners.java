package step4.service.dto;

import step4.domain.Names;

import java.util.Objects;

public class Winners {

    private final Names winners;

    private Winners(Names winners) {
        this.winners = winners;
    }

    public static Winners create(Names names) {
        return new Winners(names);
    }

    public Names getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
