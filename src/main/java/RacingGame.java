import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame(int time, int count) {
        this.time = time;
        this.carPositions = new int[count];
    }

    public int getTime() {
        return this.time;
    }

    public int[] getCarPosition() {
        return this.carPositions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int count = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame game = new RacingGame(time, count);
        GameProgress progress = new GameProgress();

        progress.progress(game);

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
