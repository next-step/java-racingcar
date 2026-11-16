package racingcar;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RacingCarApplication {



    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("자동차 대수는 몇 대 인가요?");
        String inputCarCount = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputCarCount).matches()) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
        int carCount = Integer.parseInt(inputCarCount);


        System.out.println("시도할 회수는 몇 회 인가요?");
        String inputTimes = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputTimes).matches()) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        int times = Integer.parseInt(inputTimes);


        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(0);
        }


        System.out.println("실행 결과");
        Random random = new Random();

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < carCount; j++) {
                int value = random.nextInt(10);
                Car car = cars[j];
                if (value >= 4) {
                    car.moveForward();
                }
            }


            for (int j = 0; j < carCount; j++) {

                int dis = cars[j].getPosition();

                for (int k = 0; k < dis; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }

    }


}
