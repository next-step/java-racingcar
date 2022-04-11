package me.devyonghee.racingcar.model;

public interface MovementPolicy {

    Movement movement();

    class Fake implements MovementPolicy {

        private final boolean isMoved;

        public Fake(boolean isMoved) {
            this.isMoved = isMoved;
        }

        @Override
        public Movement movement() {
            if (isMoved) {
                return Movement.MOVE;
            }
            return Movement.STOP;
        }
    }
}
