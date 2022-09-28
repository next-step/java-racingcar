package racingcar.model;

import racingcar.model.nickname.Nickname;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;
    private final Nickname nickname;

    public Car(String nickname) {
        this.nickname = new Nickname(nickname);
    }

    public void move(Condition carCondition) {
        if (carCondition.inspect()) {
            this.position = position + 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return nickname.getValue();
    }
}
