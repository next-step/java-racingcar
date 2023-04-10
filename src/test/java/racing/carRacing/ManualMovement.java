package racing.carRacing;

public class ManualMovement implements MovementStrategy{

    private final int manualNumber;
    private final int condition;

    public ManualMovement(int manualNumber, int condition) {
        this.manualNumber = manualNumber;
        this.condition = condition;
    }

    @Override
    public boolean movement() {
        return manualNumber >= condition;
    }

    public int getManualNumber() {
        return manualNumber;
    }
}
