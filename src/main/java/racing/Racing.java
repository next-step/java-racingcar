package racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Racing {

    private Racing() {

    }

    public static Map<Integer, Integer> racing(int carCount, int moveCount) {
        if (carCount <= 0 || moveCount <= 0) {
            throw new IllegalArgumentException("입력값으로 0이나 음수를 넣을 수 없습니다.");
        }

        LinkedHashMap<Integer, Integer> cars = new LinkedHashMap<>();
        initCarMap(carCount, cars);

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            moveCars(cars);
            System.out.println(" ");
        }

        return cars;
    }

    private static void moveCars(LinkedHashMap<Integer, Integer> cars) {
        for (Integer carKey : cars.keySet()) {
            int move = cars.get(carKey) + moveRandom();
            cars.put(carKey, move);
            InputView.render(move);
        }
    }

    private static void initCarMap(int carCount, LinkedHashMap<Integer, Integer> cars) {
        for (int i = 0; i < carCount; i++) {
            cars.put(i, 1);
        }
    }

    private static int moveRandom() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            return 1;
        }
        return 0;
    }
}
