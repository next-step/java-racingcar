package racing;

public class Car {
    private static final int CAR_NAME_LENGTH = 5;
    private Long position;
    private String name;

    Car(String name) {
        this.position = 0L;
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void forward(boolean condition) {
        if (condition) this.position++;
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
