package step4;

public class RacingCar {

    private final int MOVE_LENGTH = 1;

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

    private static void validateName(String name) {
        validateNameLongerThenFive(name);
        validateNameIsEmpty(name);
    }

    private static void validateNameLongerThenFive(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static void validateNameIsEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("자동차의 이름은 빈 문자열로 설정할 수 없습니다.");
        }
    }
}
