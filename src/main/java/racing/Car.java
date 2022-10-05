package racing;

public class Car {
    private Engine engine = new BasicEngine();
    private int position = 0;

    public int move() {
        if (engine.canMove()) {
            ++position;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
