package game;

public class Car {
    private final CarPosition position = new CarPosition();

    public void drive() {
        position.addRecord(CarEngine.turn());
    }

    public CarAction positionOfRep(int rep) {
        return position.carActionRecordByRep(rep);
    }

    public int moveCount() {
        return position.carActionRecordCount();
    }
}