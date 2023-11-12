package racingcar.model;

import java.util.List;

public class Positions {

        private final List<Position> positions;

        public Positions(List<Position> positions) {
                this.positions = positions;
        }

        public int getMaxPosition() {
                return positions.stream().mapToInt(Position::getNumber).max().getAsInt();
        }
}
