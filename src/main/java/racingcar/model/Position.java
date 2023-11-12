package racingcar.model;

public class Position {

        private static final int START_INIT_VALUE = 1;
        private int number;

        public Position() {
                this.number = START_INIT_VALUE;
        }

        public boolean isSamePosition(int number) {
                return this.number == number;
        }

        public void addOnePosition() {
                ++this.number;
        }

        public int getNumber() {
                return this.number;
        }
}
