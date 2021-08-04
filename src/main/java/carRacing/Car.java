package carRacing;


public class Car {

    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;

    private int position;
    private String name;

    public Car(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 ~ 5자 사이여야 합니다.");
        }
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    int go(CarMovingStrategy carMovingStrategy) {
        return carMovingStrategy.isMove() ? ++position : position;
    }
}
