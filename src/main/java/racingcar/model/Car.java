package racingcar.model;

public class Car {

        private static final int LOWER_LIMIT = 4;
        private final Name name;
        private final Position currentPosition;

        public Car(String name) {
                this.name = new Name(name);
                this.currentPosition = new Position();
        }

        public void movedForwardIfCan(int randomNumber) {
                if (isAbleToMove(randomNumber)) {
                        this.moveForward();
                }
        }

        private void moveForward() {
                currentPosition.addOnePosition();
        }

        private boolean isAbleToMove(int randomNumber) {
                return randomNumber >= LOWER_LIMIT;
        }

        public Position currentPosition() {
                return currentPosition;
        }

        public Name name() {
                return name;
        }
}
