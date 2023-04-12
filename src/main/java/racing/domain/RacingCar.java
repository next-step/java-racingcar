package racing.domain;

import racing.strategy.MoveStrategy;

public class RacingCar implements Comparable<RacingCar> {
    private static final int START_POSITION = 0;
    private final MoveStrategy moveStrategy;
    private int position;
    private final String name;

    public RacingCar(String name, MoveStrategy moveStrategy) {
        this.name = validateName(name);
        this.position = START_POSITION;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (moveStrategy.move()) {
            position++;
        }
    }

    private String validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return name;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(this.position, o.position);
    }
}
