package racinggame.View;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class InputGame {
    public Map<String, Object> inputData() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> input = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        input.put("carsName", scanner.nextLine());
        System.out.println("자동차 대수는 몇 대 인가요?");
        input.put("countCars", scanner.nextInt());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        input.put("countGames", scanner.nextInt());

        for(String key : input.keySet()) {
            nullCheck(input, key);
        }

        input.put("carsName", String.valueOf(input.get("carsName")).trim());

        return input;
    }

    public void nullCheck(Map<String, Object> input, String inputKey) {
        if (StringUtils.isEmpty(String.valueOf(input.get(inputKey)))) {
            throw new IllegalArgumentException();
        }
    }
}
