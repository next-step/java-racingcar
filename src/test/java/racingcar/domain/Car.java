package racingcar.domain;

public class Car {
    private final char display = '-';
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
