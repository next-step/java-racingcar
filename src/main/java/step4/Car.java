package step4;

import java.util.Random;

public class Car {
    private static final int NAME_LENGTH = 5;
    private static final int BETWEEN_ZERO_AND_NINE = 10;
    private static final int CONDITION = 4;
    private static final Random random = new Random();

    private String name;
    private Position position;

    public Car(String name, Position position) {

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public void moveOrStop() {
        if (isSatisfiedConditionForMove(getRandomNum())) {
            position.move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int getRandomNum() {
        return random.nextInt(BETWEEN_ZERO_AND_NINE);
    }

    public boolean isSatisfiedConditionForMove(int randomNumber) {
        return randomNumber >= CONDITION;
    }
}
