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

        start(carNumber, tryCount);
    }


    public int createRandom() {
        return random.nextInt(10);
    }

    public boolean isGoingForward(int value) {
        return value >= 4;
    }

    public void start(int carNumber, int tryCount) {
        System.out.println("실행 결과");
        String[] raceResult = new String[carNumber];
        for(int i=0; i<carNumber; i++){
            raceResult[i] = "";
        }
        while(tryCount-->0) {
            for(int i=0; i<carNumber; i++){
                if(isGoingForward(createRandom())){
                    raceResult[i] = raceResult[i] + "-";
                }
                System.out.println(raceResult[i]);
            }
            System.out.println();
        }
    }
}
