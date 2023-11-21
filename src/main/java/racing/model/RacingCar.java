package racing.model;

public class RacingCar {
    public static final int CAN_I_MOVE = 4;

    private int moveCondition;
    private String name;

    public RacingCar(int moveCondition, String name) {
        this.moveCondition = moveCondition;
        this.name = name;
    }

    public void race(int randomValue) {
        if (notMovable(randomValue)) {
            return;
        }
        this.moveCondition++;
    }

    public int max(int number) {
        return Math.max(moveCondition, number);
    }

    private boolean notMovable(int randomValue) {
        return randomValue < CAN_I_MOVE;
    }

    public int getMoveCondition() {
        return this.moveCondition;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameProgress(int progress){
        return this.moveCondition == progress;
    }
}
