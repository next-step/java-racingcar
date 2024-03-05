import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CarRacingGame {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;

    public static void carRacing(/*int carCount, int trialCount*/) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int trialCount = scanner.nextInt();

        int [] carPositions = new int[carCount];

        for(int trial = 0; trial <trialCount; trial++){
            System.out.println( (trial+1) +"회차 이동");
            for(int car = 0; car < carCount; car++){
                if(decideToMove()){
                    carPositions[car] += 1;
                }
            }
            printMovement(carPositions);
            System.out.println();
        }
    }

    private static boolean decideToMove(){
        Random random = new Random();
        return (random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD);
    }

    private static void printMovement(int[] carPositions){
        for(int position : carPositions){
            for(int track = 0; track < position; track++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}