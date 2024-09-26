import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private int[] car;
    private int carCount;
    private int moveCount;
    public RacingCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        this.carCount = carCount;
        this.car = new int[carCount];
        System.out.println(carCount);

        System.out.println("시도할 회수는 몇 회인가요?");
        int moveCount = scanner.nextInt();
        this.moveCount = moveCount;
        System.out.println(moveCount);
    }
}
