package racing.carRacing;

public class ManualMovement implements MovementStrategy{

    private final int manualNumber;

    public ManualMovement(int manualNumber) {
        this.manualNumber = manualNumber;
    }

    @Override
    public int movement() {
        return manualNumber;
    }
}
