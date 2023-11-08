package racing;

import java.util.Map;
import java.util.Random;

public class CarRacingMain {
    private static final String NUMBER = "number";
    private static final String COUNT = "count";

    public static void start() {
        Map<String, Integer> input = InputView.inputResult();

        ResultView.init(input);
        play(input.get(NUMBER), input.get(COUNT));

        System.out.println("실행 결과");
        ResultView.racingResult();
    }

    public static void play(int number, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < number; j++) {
                goOrStop(i, j);
            }
        }
    }

    public static void goOrStop(int i, int j) {
        if (new Random().nextInt(10) >= 4) {
            ResultView.concat(i, j, "-");
            return;
        }
        ResultView.concat(i, j, "");
    }
}
