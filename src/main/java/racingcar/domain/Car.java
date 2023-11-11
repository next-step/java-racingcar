package racingcar.domain;

public class Car {

        private static final int LOWER_LIMIT = 4;
        private final Name name;
        private final Position currentPosition;

        public Car(String name) {
                this.name = new Name(name);
                this.currentPosition = new Position();
        }

        public void movedForwardIfCan(int randomNo) {
                if (isAbleToMove(randomNo)) {
                        this.moveForward();
                }
        }

        private void moveForward() {
                currentPosition.addOnePosition();
        }

        private boolean isAbleToMove(int randomNo) {
                return randomNo >= LOWER_LIMIT;
        }

        public Position currentPosition() {
                return currentPosition;
        }

        public Name name(){
                return name;
        }
}
