package racingcarGame;

import static racingcarGame.client.MessageClient.show;
import static racingcarGame.dto.GameData.getRandomBaseValue;

public class Car {
    private static final String POSITION_STR = "-";

    private int position;
    private String movement;

    public Car(int position, String movement) {
        this.position = position;
        this.movement = movement;
    }

    public Car move() {
        if (isMovable()) {
            this.position += 1;
            this.movement += POSITION_STR;
        }

        return new Car(position, movement);
    }

    private boolean isMovable() {
        return RandomNumber.generate() >= getRandomBaseValue();
    }

    public void showMovement() {
        show(this.movement);
    }
}
