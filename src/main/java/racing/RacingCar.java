package racing;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private String carName;
    private int position;

    public RacingCar(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    protected int move(int number) {
        if (this.isMove(number)) {
            this.position++;
        }
        return this.position;
    }

    private boolean isMove(int number) {
        return number >= this.FORWARD_NUM;
    }

    protected int getPosition() {
        return this.position;
    }

    protected String getName() {
        return this.carName;
    }

    @Override
    public String toString() {
        String position = "";
        for (int i = 0; i < this.position; i++) {
            position += "-";
        }
        return this.carName + " : " + position;
    }
}
