package racingcar.view;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputManager implements Closeable {
    private final static String ROUND_INPUT_STRING = "시도할 회수는 몇회인가요?";
    private final static String CAR_NAMES_INPUT_STRING = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final BufferedReader bufferedReader;

    public InputManager() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readRound() throws IOException {
        System.out.println(ROUND_INPUT_STRING);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public List<String> readCarNames() throws IOException {
        System.out.println(CAR_NAMES_INPUT_STRING);
        return List.of(bufferedReader.readLine().split(","));
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
