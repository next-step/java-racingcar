package racingcar.domain;

public class Car {
    private String name;
    private int position;
    private final static int CarLength = 5;

    public Car(String name) {
        isCarNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void isCarNameLength(String input) {
        if(input.length() > CarLength) {
            throw new IllegalArgumentException("차 이름은 5자 이하로만 이뤄질 수 있습니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
