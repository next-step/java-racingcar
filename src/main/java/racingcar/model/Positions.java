package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Positions {

        private final List<Position> values;

        public Positions(List<Position> values) {
                this.values = values;
        }

        public Position getMaxPosition() {
                Comparator<Position> comparatorByPosition = Comparator.comparingInt(Position::getValue);
                return values.stream().max(comparatorByPosition).orElseThrow(NoSuchElementException::new);
        }
}
