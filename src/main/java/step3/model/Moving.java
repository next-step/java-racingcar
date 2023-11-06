package step3.model;

public class Moving {

    private static final String MOVE = "-";

    private String value;

    public Moving() {
        this.value = "";
    }

    public void move(int movingNumber) {
        if (movingNumber >= 4) {
            value += MOVE;
        }
    }

    public String getMove() {
        return value;
    }
}
