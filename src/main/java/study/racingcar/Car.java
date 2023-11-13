package study.racingcar;

public class Car {

    private final String name;

    private static final int MOVE_CONDITION = 4;

    public Car(String name) {
        carNameValidation(name);
        this.name = name;
    }

    private static void carNameValidation(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public MoveStatus canMove(RandomGenerator randomGenerator) {
        if (pickRandomValue(randomGenerator) >= MOVE_CONDITION) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private int pickRandomValue(RandomGenerator randomGenerator) {
        return randomGenerator.number();
    }

    public String name() {
        return this.name;
    }
}
