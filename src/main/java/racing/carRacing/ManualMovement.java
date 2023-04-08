package racing.carRacing;

public class ManualMovement implements MovementStrategy{

    private int manualNumber;

    public ManualMovement(int manualNumber) {
        this.manualNumber = manualNumber;
    }

    @Override
    public int movement() {
        return manualNumber;
    }
}
