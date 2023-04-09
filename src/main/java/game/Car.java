package game;

public class Car {
    private final CarPosition position = new CarPosition();

    public void drive() {
        position.addRecord(CarEngine.turn());
    }

    public CarPosition position() {
        return position;
    }

    public int moveCount() {
        return position.carActionRecordCount();
    }
}