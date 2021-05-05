package step5.domain;

import static step5.Util.validateInput;

public class Car {
    private static final int STARTING_POINT = 0;
    public static final int MAX_NAME_SIZE = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, STARTING_POINT);
    }

    public Car(String name, int position) {
        String validName = validateInput(name);
        validateNameSize(validName);
        this.name = validName;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    private static void validateNameSize(String names) {
        if (names.length() > MAX_NAME_SIZE)
            throw new IllegalArgumentException("이름은 " + MAX_NAME_SIZE + "글자를 넘어갈 수 없습니다.");
    }

}
