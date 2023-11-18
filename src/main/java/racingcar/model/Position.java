package racingcar.model;

public class Position implements Comparable<Position> {

        private static final int START_INIT_VALUE = 1;
        private int value;

        public Position() {
                this.value = START_INIT_VALUE;
        }

        public void addOnePosition() {
                ++this.value;
        }

        public int getValue() {
                return this.value;
        }

        @Override
        public int compareTo(Position o) {
                return this.value - o.getValue();
        }

        boolean isSamePosition(Position position) {
                return compareTo(position) == 0;
        }

}
