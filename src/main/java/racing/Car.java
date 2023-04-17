package racing;

public class Car {
    private Long position;
    private String name;
    
    private static final int CAR_NAME_LENGTH = 5;

    public Car(String name) {
        this.position = 0L;
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward(MovingStrategy strategy) {
        if (strategy.isMovable()) this.position++;
    }

    public Long getPosition() {
        return position;
    }

    private void validateCarName(String carName) {
        if (StringValidator.isBlank(carName) || !StringValidator.isLessThanEqualLen(carName, CAR_NAME_LENGTH)) {
            throw new RuntimeException("이름이 유효하지 않습니다.");
        }
    }
}
