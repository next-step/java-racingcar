package racingcar;

public class Car {

    private static final Integer MOVE_MINIMUM_CONDITION = 4;
    private static final Integer MOVE_MAXIMUM_CONDITION = 9;

    private Integer position = 0;

    public void move(RandomValueGenerator randomValueGenerator) {
        if (judgeForth(randomValueGenerator.generate())) {
            position++;
        }
    }

    public boolean judgeForth(int degree) {
        return (degree >= MOVE_MINIMUM_CONDITION) && (degree <= MOVE_MAXIMUM_CONDITION);
    }

    public int showNowPosition() {
        return position;
    }

}
