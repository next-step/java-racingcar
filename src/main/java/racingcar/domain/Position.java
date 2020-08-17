package racingcar.domain;

import racingcar.strategy.DoRace;
import racingcar.strategy.RaceCondition;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move(RaceCondition raceCondition, DoRace doRace) {
        if (raceCondition.pass( )) {
            this.position = position + doRace.race( );
        }
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
