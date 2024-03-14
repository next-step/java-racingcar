package racingcar.domain;

public class Car {
    private static final String display = "-";
    int location;

    public void move() {
        location++;
    }

    public void position() {
        for (int i = 0; i <= location; i++) {
            System.out.print(display);
        }
    }
}
