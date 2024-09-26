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

        race();
    }

    private void race() {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (int cc = 0; cc < carCount; cc++) {
                int randomInt = getRandomInt();
                if (randomInt >= 4) {
                    car[cc]++;
                }
            }
            printRaceCondition();
        }
    }

    private void printRaceCondition() {
        for (int i = 0; i < carCount; i++) {
            System.out.println("-".repeat(car[i]));
        }
        System.out.println();
    }

    private int getRandomInt() {
        return new Random().nextInt(10);
    }

    public static RacingCar main() {
        new RacingCar();
        return null;
    }

}
