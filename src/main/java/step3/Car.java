package step3;


public class Car {

    private static final int MOVE_NUM = 4;

    private int carNumber;
    private int move;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public void updateMove(int random) {
        if (random >= MOVE_NUM) {
            this.move++;
        }
    }

    public void print() {
        ResultView.print(this.move);
    }
}
