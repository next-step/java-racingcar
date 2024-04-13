import java.util.Scanner;

public class RacingCar {

    private static final Scanner scanner = new Scanner(System.in);

    private int carCount;
    private int moveCount;

    private final MovePolicy movePolicy = new RandomMove();
    private final Printer printer = new Printer();

    public void start() {
        int[] result = new int[carCount];

        for (int i = 0; i < moveCount; i++) {
            for (int j = 0; j < carCount; j++) {
                if (movePolicy.isAbleToMove()) {
                    result[j] += 1;
                }
            }
        }

//        printer.print(result);
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
