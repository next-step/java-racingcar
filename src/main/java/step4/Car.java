package step4;

public class Car {

    public static final int MAX_NAME = 4;
    public static final int POSSIBLE_MOVE = 3;

    private int position;
    private String name;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position++;
    }

    private void validName(String name) {
        if (name.length() > MAX_NAME) {
            throw new IllegalArgumentException("이름을 5자이상 사용할수 없습니다.");
        }
    }

    public void move(int random) {
        if (random > POSSIBLE_MOVE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
