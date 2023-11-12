package racingcar4.model;


//자동차 자체 모델
public class Car {
    private static final int ADVANCE_MINIMUM_VALUE = 4;
    private static final int NAME_LENGTH_MAXIMUM = 5;
    private int position;
    private final String name;

    public Car(String name) {
        this.position = 0;
        carNameTest(name);
        this.name = name;
    }

    private boolean canMove(int number) {
        return number >= ADVANCE_MINIMUM_VALUE;
    }

    private void forwardOneStep(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public void carTurn(int number) {
        boolean canMove = canMove(number);
        forwardOneStep(canMove);
    }


    //글자수 초과
    private void carNameTest(String name) {
        if (name.length() > NAME_LENGTH_MAXIMUM) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    //자동차 이름 출력
    public String getName() {
        return name;
    }

    public int maxPosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public boolean victoryCar(int maxPosition) {
        return position == maxPosition;
    }

    public void getStatus() {
        System.out.println(name + " : " + "-".repeat(position));
    }
}
