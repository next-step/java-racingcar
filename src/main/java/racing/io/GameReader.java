package racing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing.exception.GameReadyException;
import racing.model.GameReadyInfo;

public class GameReader {

    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    public GameReadyInfo readyGame() {
        try (final BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            final String carNames = inputCarNames(input);
            final int tryCount = inputRaceCount(input);
            return new GameReadyInfo(carNames, tryCount);
        } catch (final IOException e) {
            throw new GameReadyException(e);
        }
    }

    private String inputCarNames(final BufferedReader input) throws IOException {
        System.out.println(CAR_NAMES_INPUT_GUIDE);
        return input.readLine();
    }

    private int inputRaceCount(final BufferedReader input) throws IOException {
        System.out.println(RACE_COUNT_INPUT_GUIDE);
        return Integer.parseInt(input.readLine());
    }
}
