package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static RacingGameCondition inputRacingCarGameCondition() {
        final Map<String, String> conditionKeyQuestionMap = new LinkedHashMap<>() {{
            put("racingCarCount", "자동차 대수는 몇 대 인가요?");
            put("gameTurnCount", "시도할 회수는 몇 회 인가요?");

        }};
        Map<String, Integer> conditionKeyInputMap = new HashMap<>(conditionKeyQuestionMap.size());

        Scanner scanner = new Scanner(System.in);
        conditionKeyQuestionMap.forEach((key, value) -> {
            System.out.println(value);
            conditionKeyInputMap.put(key, scanner.nextInt());
        });

        return new RacingGameCondition(
                conditionKeyInputMap.get("racingCarCount"),
                conditionKeyInputMap.get("gameTurnCount"));
    }
}
