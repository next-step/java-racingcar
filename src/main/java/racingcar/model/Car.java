package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;

public class Car {

        private final Name name;
        private final Position currentPosition;
        private final MoveStrategy moveStrategy;

        public Car(String name, MoveStrategy moveStrategy) {
                this.name = new Name(name);
                this.currentPosition = new Position();
                this.moveStrategy = moveStrategy;
        }

        public Position currentPosition() {
                return currentPosition;
        }

        public Name name() {
                return name;
        }

        public void moveForwardIfCan() {
                if (moveStrategy.isAbleToMove()) {
                        this.moveForward();
                }
        }

        private void moveForward() {
                currentPosition.addOnePosition();
        }

}
