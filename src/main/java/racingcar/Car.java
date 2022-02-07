package racingcar;

public class Car {

    static final int INIT_POSITION = 0;

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
        checkCarName();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void go() {
        this.position++;
    }

    public void checkCarName() {
        if (name.length() > 5) {
            throw new RuntimeException("차의 이름은 5글자가 넘으면 안됩니다.");
        }
    }
}
