package study.step3;

import java.util.*;

public class CarRacing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = scanner.nextInt();
        System.out.println("\n실행 결과");

        racing(carNum, tryNum);
    }

    private static void racing(int carNum, int tryNum) {
        String[] positionArray = new String[carNum];
        Arrays.fill(positionArray, "");

        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carNum; j++) {
                if (isSuccess()) {
                    positionArray[j] += "-";
                }
                System.out.println(positionArray[j]);
            }
            System.out.println();
        }
    }
    private static boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }
}
