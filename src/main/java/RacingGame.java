import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RacingGame game = new RacingGame();
        System.out.println("자동차 대수는 몇 대 인가요?");
        int count = scanner.nextInt();
        game.carPositions = new int[count];

        System.out.println("시도할 회수는 몇 회 인가요?");
        game.time = scanner.nextInt();

//      System.out.println("자동차 대수: " + count);
//      System.out.println("시도할 횟수: " + game.time);

        for (int i = 0; i < game.time; i++) {
            game.move();
            game.resultView();
            System.out.println("");
        }

    }

    public int[] move() {
        Random random = new Random();

        for (int i = 0; i < carPositions.length; i++) {
            int ranCount = random.nextInt(10);
            if (ranCount >= 4) {
                carPositions[i] = carPositions[i] + 1;
            }
        }

        return carPositions;
    }

    public void resultView() {
        for (int i = 0; i < carPositions.length; i++) {
            for (int j = 0; j < carPositions[i]; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }

    }

}
