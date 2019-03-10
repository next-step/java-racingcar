package racingcar;

public class Car {

    private final int randomNum;
    private int move;
    private int position;

    public Car(int randomNum) {
        this.randomNum = randomNum;

        if (checkCanMove(randomNum)) {
            this.move = 1;
        }
    }

    public static boolean checkCanMove(int num) {
        return num >= 4 && num <= 9;
    }

    public int getMove() {
        return move;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
