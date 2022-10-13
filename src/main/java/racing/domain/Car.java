package racing.domain;

public class Car {

    private static final String MOVE_PATTERN = "-";
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        int moveNumber = Moving.moveNumber();
        position += moveNumber;
    }

    public void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_PATTERN);
        }
        System.out.println();
    }
}
