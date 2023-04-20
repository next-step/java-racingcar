package racingcar;

public class Car {

    private String name;
    private Integer position = 0;
    private static final Integer MOVE_MINIMUM_CONDITION = 4;
    private static final Integer MOVE_MAXIMUM_CONDITION = 9;

    public Car(String name) {
        this.name = name;
    }

    public void move(RandomValueGenerator randomValueGenerator) {
        if (judgeForth(randomValueGenerator.generate())) {
            position++;
        }
    }

    private boolean judgeForth(int degree) {
        return (degree >= MOVE_MINIMUM_CONDITION) && (degree <= MOVE_MAXIMUM_CONDITION);
    }

    public int showNowPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
