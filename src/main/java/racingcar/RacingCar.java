package racingcar;

public class RacingCar {

    private final int MOVE_LENGTH = 1;
    private final int MAX_LENGTH_NAME = 5;

    private String name;
    private int position = 0;

    private RacingCar() {
    }

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            position += MOVE_LENGTH;
        }
    }

    public boolean isEqualsPosition(int position) {
        return this.position == position;
    }

    private void validateName(String name) {
        validateNameLongerThenFive(name);
        validateNameIsEmpty(name);
    }

    private void validateNameLongerThenFive(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateNameIsEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("자동차의 이름은 빈 문자열로 설정할 수 없습니다.");
        }
    }
}
