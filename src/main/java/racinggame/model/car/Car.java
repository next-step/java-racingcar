package racinggame.model.car;

import java.util.Objects;
import racinggame.model.position.Position;

public class Car {
    private Position position;
    private String name;

    private static final int STANDARD_TO_ADVANCE = 4;
    private static final String RACE_STATE_PER_CAR_DELIMITER = " : ";

    public Car(String name) {
        this.position = new Position();
        this.name = name;
    }

    public void move(int inputValue) {
        if (isKeep(inputValue)) {
            return;
        }

        this.position.plus();
    }

    private boolean isKeep(int inputValue) {
        return inputValue < STANDARD_TO_ADVANCE;
    }

    public boolean isSamePosition(Position checkPosition) {
        return this.position.equals(checkPosition);
    }

    public boolean hasDownPosition(Position checkPosition) {
        return this.position.hasDownPosition(checkPosition);
    }

    public String getCarNameIfMaxPosition(Position checkPosition) {
        if (isSamePosition(checkPosition)) {
            return this.name;
        }

        // TODO 이런식의 기본값 응답은 어떻게 생각하시나요? 상황에 따라 기본값응답 vs 예외처리 로 생각하고 있는데 다른방법이 있을까요?
        return "";
    }

    public Position compareAndChangeIfMax(Position maxPosition) {
        if (hasDownPosition(maxPosition) || isSamePosition(maxPosition)) {
            return maxPosition;
        }
        
        return this.position;
    }

    public String getStateMessage() {
        return this.name
                + RACE_STATE_PER_CAR_DELIMITER
                + this.position.getStateMessage();
    }
    
    // TODO : default 접근자로 설정해 해당 패키지내에서만 호출할 수 있는 일종의 set 메서드를 만들어내서 테스트에서 사용하는데.. 이 방법은 어떻게 생각하시나요?
    void updatePosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

}
