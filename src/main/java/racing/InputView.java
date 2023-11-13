package racing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public static Map<String, Integer> inputData() {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> inputData = new HashMap<>();

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputData.put("car", scanner.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputData.put("racingCount", scanner.nextInt());

        return inputData;
    }

    public static int inputNumberOfCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");

        return scanner.nextInt();
    }

    public static int inputRacingCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");

        return scanner.nextInt();
    }
}
