package step3;

public class Car {

    private static final int MOVE_BOUND = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move(int random) {
        if (canMove(random)) {
            position++;
        }
    }

    private boolean canMove(int random) {
        return random >= MOVE_BOUND;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

}
