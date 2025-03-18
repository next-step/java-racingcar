import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private final Random random = new Random();

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();
    }


    public int createRandom() {
        return random.nextInt(10);
    }

    public boolean isGoingForward(int value) {
        return value >= 4;
    }

}
