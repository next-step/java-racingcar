package RacingCar;

import java.util.*;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int movementCount = scanner.nextInt();

        System.out.println("\n실행 결과");
        runCar(carCount, movementCount);
    }

    private static void runCar(int carCount, int movementCount) {
        String[] currentCarList = new String[carCount];
        Arrays.setAll(currentCarList, i -> "");
        for (int time=0; time<movementCount; time++) {
            for (int carNumber=0; carNumber<carCount; carNumber++) {
                Random random = new Random();
                int goValue = random.nextInt(10);
                if (goValue >= 4) {
                    currentCarList[carNumber] += "-";
                }
                System.out.println(currentCarList[carNumber]);
            }
            if (time+1 < movementCount) {
                System.out.println("\n");
            }
        }
    }
}
