package racing.domain;

public class Car {

    public static final int MOVE_CONDITION = 4;
    private final String name;

    private int position;


    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(GenerateNumber generateNumber) {
        if (isMove(generateNumber.getRandomNumber())) {
            position++;
        }
    }

}
