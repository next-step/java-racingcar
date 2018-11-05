package racing_game;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RacingGameReader implements AutoCloseable {

    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");

    private final Scanner scanner;


    public RacingGameReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String line = scanner.nextLine();
        return SPLIT_PATTERN.split(line);
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
