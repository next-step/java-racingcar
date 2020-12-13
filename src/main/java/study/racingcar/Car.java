package study.racingcar;

public class Car {

    private static final int FORWARD_NUM = 4;
    private int position;
    private final String name;

//    public Car() {
//        this.position = 0;
//        this.name = "";
//    }

    public Car(String name) {
        validateName(name);
        this.position = 0;
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int randomNo) {
        if (FORWARD_NUM <= randomNo) {
            advanced();
        }
    }

    public void advanced() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
