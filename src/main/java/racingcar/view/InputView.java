package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TOTAL_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String inputNames() throws IOException {
        System.out.println(INPUT_NAMES_MESSAGE);
        return bufferedReader.readLine();
    }

    public String inputTotalRound() throws IOException {
        System.out.println(INPUT_TOTAL_ROUND_MESSAGE);
        return bufferedReader.readLine();
    }
}
