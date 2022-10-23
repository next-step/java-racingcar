package carracing.domain;

import org.apache.commons.lang3.StringUtils;

public class Car {

    public String name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(name, new Position(position));
    }

    public Car(final String name, final Position position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다");
        }
        this.name = name.trim();
        this.position = position;
    }

    public boolean isMaxPosition(int position) {
        return this.position.isMaxPosition(position);
    }

    public int maxPosition(int position) {
        return this.position.maxPosition(position);
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
//            int result = position2.getPosition()+1;
//            position2.setPosition(result);
//            이런 짓을 하지 말자
            this.position = position.increase();
        }
    }

    public String getPositionTrail() {
        return this.position.getPositionTrail();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}

