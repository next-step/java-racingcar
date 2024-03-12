import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        racingCar.inputCarAndMoveCount();
        racingCar.start();
    }

    private int carCount;
    private int moveCount;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int rangeRandom = 10;
    private static final int cutMove = 4;

    public void inputCarAndMoveCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.moveCount = scanner.nextInt();
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

    public void start() {
        System.out.println("실행 결과");
        int[] result = new int[carCount];

        for (int i = 0; i < moveCount; i++) {
            for (int j = 0; j < carCount; j++) {
                if (isAbleToMove()) {
                    result[j] += 1;
                }
            }
        }

        printResult(result);
    }

    private boolean isAbleToMove() {
        return random.nextInt(rangeRandom) >= cutMove;
    }

    private void printResult(int[] result) {
        for (int i = 0; i < moveCount; i++) {
            for (int k = 0; k < carCount; k++) {
                for (int x = 0; x < result[k]; x++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
