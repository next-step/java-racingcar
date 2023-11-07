package carracing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class CarRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = carInputProcess(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = carInputProcess(scanner.nextLine());

        letsRace(tryNumber, carNumber);
    }

    private static void letsRace(int tryNumber, int carNumber) {
        Random random = new Random();
        String[] carGarage = new String[carNumber];
        Arrays.fill(carGarage, "");

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {

            for (int j = 0; j < carNumber; j++) {
                int randomRun = random.nextInt(10);
                if (randomRun >= 4) {
                    carGarage[j] += '-';
                }
                System.out.println(carGarage[j]);
            }
            System.out.println();
        }
    }

    public static int carInputProcess(String text) {
        try {
            if (isBlank(text)) {
                return 0;
            }
            if (text.contains("-")) throw new IllegalArgumentException();

            return toInt(text);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다." + e.getMessage());
        }
        return toInt(text);
    }


    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}