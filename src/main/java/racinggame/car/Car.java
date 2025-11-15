package racinggame.car;

import java.util.Objects;

public class Car {
    private int position;
    private String name;

    private static final int DEFAULT_POSITION = 0;
    private static final int PLUS_POSITION = 1;
    private static final int STANDARD_TO_ADVANCE = 4;
    private static final String RACE_STATE_PER_CAR_DELIMITER = " : ";

    public Car(String name) {
        this.position = DEFAULT_POSITION;
        this.name = name;
    }

    public void move(int inputValue) {
        if (isKeep(inputValue)) {
            return;
        }

        this.position += PLUS_POSITION;
    }

    private boolean isKeep(int inputValue) {
        return inputValue < STANDARD_TO_ADVANCE;
    }

    public boolean isSamePosition(int checkPosition) {
        return this.position == checkPosition;
    }

    public String getCarNameIfMaxPosition(int checkPosition) {
        // TODO 이런식의 기본값 응답은 어떻게 생각하시나요? 상황에 따라 기본값응답 vs 예외처리 로 생각하고 있는데 다른방법이 있을까요?
        if (!isSamePosition(checkPosition)) {
            return "";
        }

        return this.name;
    }

    public boolean hasDownPosition(int checkPosition) {
        return this.position < checkPosition;
    }

    public int compareAndChangeIfMax(int maxPosition) {
        if (hasDownPosition(maxPosition) || isSamePosition(maxPosition)) {
            return maxPosition;
        }
        
        return this.position;
    }

    public String getStateMessage() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append(RACE_STATE_PER_CAR_DELIMITER);
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
    
    // TODO : default 접근자로 설정해 해당 패키지내에서만 호출할 수 있는 일종의 set 메서드를 만들어내서 테스트에서 사용하는데.. 이 방법은 어떻게 생각하시나요?
    void updatePosition(int position) {
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
