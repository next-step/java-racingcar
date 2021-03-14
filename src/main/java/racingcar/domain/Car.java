package racingcar.domain;

public class Car {

    private static final int LOWER_LIMIT = 0;
    private static final int HIGHER_LIMIT = 9;
    private Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

   public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void updatePositionByCondition(int number) {
        conditionValueValidation(number);

        position.update(number);
    }

    public void conditionValueValidation(int number) {
        if (number > HIGHER_LIMIT || number < LOWER_LIMIT) {
            throw new IllegalArgumentException("0 ~ 9까지의 값만 사용할 수 있습니다.");
        }
    }
}
