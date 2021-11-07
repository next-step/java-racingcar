package race.inboud;

import java.io.Closeable;
import java.util.Scanner;

public class InputView implements Closeable {
    private final Scanner scanner = new Scanner(System.in);

    public int numberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int numberOfMovement() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
