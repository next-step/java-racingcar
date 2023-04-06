import java.util.Random;

public class Car {
    private int move;

    public Car() {
        this.move = 0;
    }

    public void moveCar(int m) {
        if (m >= 4)
            this.move++;
    }

    public int getMove() {
        return move;
    }

    public int moveOrNot() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
