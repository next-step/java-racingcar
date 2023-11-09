package racing;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Car {

    public static final int NAME_LIMIT = 5;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        lengthCheck(name);
    }

    public Car() {
    }

    public String carName() { return  name; }

    public int carDistance() {
        return distance;
    }

    public Boolean equalDistance(int distance) {
        if (this.distance == distance) {
            return TRUE;
        }
        return FALSE;
    }

    private void lengthCheck(String names) {
        if (count(name) == FALSE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }
    }

    private Boolean count(String name) {
        if (name.length() > NAME_LIMIT) {
            return FALSE;
        }
        return TRUE;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.move()) {
            distance += 1;
        }
        new ResultView().status(this.name, this.distance);
    }
}
