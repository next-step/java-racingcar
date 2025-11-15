package racingGame.model;

public class Car {


    public static final int INIT_LOCATION = 0;
    public static final int CAR_FORWARD_CRITERIA = 3;
    private String name;
    private int location;
    
    public Car(String name, int location) {
        this(name);
        this.location = location;
    }

    public Car(String name) {
        validate(name);
        this.name = name;
        this.location = INIT_LOCATION;
    }

    public int forward(int randomNum) {
        if (randomNum > CAR_FORWARD_CRITERIA) {
            location += 1;
        }
        return location;
    }

    public int findLocation() {
        return location;
    }

    public String showName() {
        return this.name;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 입력하거나, 5글자 이하이름을 쓰시오");
        }
    }
}
