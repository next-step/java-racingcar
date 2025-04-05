package carrace.rules;

import java.util.Random;

// 게임 규칙
public class CarRaceRules {

    private static final int UPPER_BOUND_FOR_RANDOM = 10;
    private static final int CAR_NAME_LIMIT = 5;

    // 이동 여부 판단에 필요한 random 값을 상한에 맞추어 반환
    public static int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND_FOR_RANDOM);
    }

    // 자동차 이름이 최대 길이를 초과하는지 검사
    public static boolean checkLargerThanMaxCarNameLength(String input) {
        return input.length() > CAR_NAME_LIMIT;
    }
}
