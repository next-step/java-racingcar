package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TOTAL_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public static Request init() throws IOException {
        String names = inputNames();
        String totalRound = inputTotalRound();

        return new Request(names, totalRound);
    }

    private static String inputNames() throws IOException {
        System.out.println(INPUT_NAMES_MESSAGE);
        return bufferedReader.readLine();
    }

    private static String inputTotalRound() throws IOException {
        System.out.println(INPUT_TOTAL_ROUND_MESSAGE);
        return bufferedReader.readLine();
    }
}
