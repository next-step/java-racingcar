package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Positions {

        private final List<Position> positions;

        public Positions(List<Position> positions) {
                this.positions = positions;
        }

        public Position getMaxPosition() {
                Comparator<Position> comparatorByPosition = Comparator.comparingInt(Position::getNumber);
                return positions.stream().max(comparatorByPosition).orElseThrow(NoSuchElementException::new);
        }
}
