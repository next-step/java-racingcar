package racing;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private String carName;
    private int position;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move(int number) {
        if (this.isMove(number)) {
            this.position++;
        }
    }

    private boolean isMove(int number) {
        return number >= this.FORWARD_NUM;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
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
