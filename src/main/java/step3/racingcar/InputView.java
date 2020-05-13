package step3.racingcar;

import java.util.HashMap;
import java.util.Scanner;

public class InputView {

    public static HashMap<String, Integer> processUserInput() {
        HashMap<String, Integer> userInputMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        userInputMap.put("numberOfCar", sc.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        userInputMap.put("gameTryCounts", sc.nextInt());
        return userInputMap;
    }
}
