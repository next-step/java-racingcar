package racingcar;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String name;
    private int position;

    Car(String name) {
        checkCarName();
        this.name = name;
        this.position = INIT_POSITION;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void go() {
        this.position++;
    }

    public void checkCarName() {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차의 이름은 5글자가 넘으면 안됩니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }


}
