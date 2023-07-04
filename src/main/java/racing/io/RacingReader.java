package racing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import racing.model.GameInfo;

public class RacingReader {

    public GameInfo startGame() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            String carNames = inputCarNames(br);
            int raceCount = inputRaceCount(br);
            return new GameInfo(carNames, raceCount);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String inputCarNames(BufferedReader input) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.readLine();
    }

    private int inputRaceCount(BufferedReader input) throws IOException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(input.readLine());
    }

}
