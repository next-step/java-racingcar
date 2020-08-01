package step3.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static Map<String, Integer> getConfiguration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();
        return makeConfiguration(numberOfCars, numberOfAttempts);
    }

    private static Map<String, Integer> makeConfiguration(int numberOfCars, int numberOfAttempts) {
        Map<String, Integer> configuration = new HashMap<>();
        configuration.put("numberOfCars", numberOfCars);
        configuration.put("numberOfAttempts", numberOfAttempts);
        return configuration;
    }

}
