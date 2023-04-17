package step4.domain.entity;

import java.util.List;
import java.util.Objects;

public class Position {

    private static final int CAR_FORWARD_MINIMUM_NUMBER = 4;

    private int distance;

    public Position() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;

        return distance == position.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    public void forward(int random) {
        if (random >= CAR_FORWARD_MINIMUM_NUMBER) {
            this.distance++;
        }
    }

    public static Position winnerPosition(List<Position> positions) {
        Position winner = positions.get(0);

        for (Position position : positions) {
            winner = compareWinner(winner, position);
        }

        return winner;
    }

    private static Position compareWinner(Position origin, Position compare) {
        if (compare.distance > origin.distance) {
            origin = compare;
        }
        return origin;
    }
}
