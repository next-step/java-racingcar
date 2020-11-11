package race.logic;


public class Car {
    private final Engine engine;
    private int position = 0;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run() {
        if (engine.canMove()) {
            position += 1;
        }
    }

    public int getCurrentPosition() {
        return position;
    }
}
