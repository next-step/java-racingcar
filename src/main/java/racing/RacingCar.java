package racing;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private int position;

    public void move(RandomStrategy randomStrategy) {
        if (this.isMove(randomStrategy)) {
            this.position++;
        }
    }

    private boolean isMove(RandomStrategy randomStrategy) {
        return randomStrategy.makeRandomNumber() >= FORWARD_NUM;
    }

    public String carPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
