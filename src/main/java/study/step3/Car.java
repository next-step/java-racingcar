package study.step3;

public class Car {
    private static final int STANDARD_VALUE_TO_MOVE = 3;

    private Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        position = 0;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    int getPosition() {
        return position;
    }

    Name getName() {
        return name;
    }

    boolean isThisName(String name) {
        return this.name.equals(new Name(name));
    }

    int move(int randomNum) {
        if (isExceedStandard(randomNum)) {
            position++;
        }
        return position;
    }

    boolean isExceedStandard(int num) {
        return num > STANDARD_VALUE_TO_MOVE;
    }

    boolean isCarPosition(int position) {
        return this.position == position;
    }
}
