package racing_game;

import java.io.InputStream;
import java.util.Scanner;

public class CountReader implements AutoCloseable {

    private final Scanner scanner;

    public CountReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
