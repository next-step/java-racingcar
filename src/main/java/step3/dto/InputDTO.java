package step3.dto;

public class InputDTO {
    private String[] carNames;
    private int turnCount;
    private int decisionValue;

    public InputDTO(String[] carNames, int turnCount, int decisionValue) {
        this.carNames = carNames;
        this.turnCount = turnCount;
        this.decisionValue = decisionValue;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getDecisionValue() {
        return decisionValue;
    }

    public void setDecisionValue(int decisionValue) {
        this.decisionValue = decisionValue;
    }
}
