package step3and4.car;

import step3and4.Positive;
import step3and4.car.move.MoveStrategy;

public class Car {
    private Positive position;
    private Name name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
        this.position = new Positive();
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position.move(moveStrategy.move());
        }
    }

    public int getPosition() {
        return this.position.number();
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean equalsPosition(int winPosition) {
        return this.position.equalsNumber(winPosition);
    }

    class Name {
        private final String name;
        private static final int NAME_MAX_LENGTH = 5;

        public Name(String name) {
            verifyNameNullOrOverFiveLength(name);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private void verifyNameNullOrOverFiveLength(String name) {
            if (name == null) {
                throw new IllegalArgumentException("이름이 없습니다.");
            }

            if (name.isBlank()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
            }

            if (name.length() >= NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("이름이" + NAME_MAX_LENGTH + "글자 이상입니다.");
            }
        }
    }
}
