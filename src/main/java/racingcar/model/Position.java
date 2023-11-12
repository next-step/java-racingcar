package racingcar.model;

public class Position implements Comparable<Position> {

        private static final int START_INIT_VALUE = 1;
        private int number;

        public Position() {
                this.number = START_INIT_VALUE;
        }

        public void addOnePosition() {
                ++this.number;
        }

        public int getNumber() {
                return this.number;
        }

        @Override
        public int compareTo(Position o) {
                return this.number - o.getNumber();
        }

        boolean isSamePosition(Position position) {
                return compareTo(position) == 0;
        }

}
