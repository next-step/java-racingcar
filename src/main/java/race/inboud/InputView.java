package race.inboud;

import race.CarName;

import java.io.Closeable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Closeable {
    private final Scanner scanner = new Scanner(System.in);

    public int numberOfMovement() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public Collection<CarName> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Collections.unmodifiableCollection(
                Arrays.stream(
                        scanner.nextLine().split(",")
                ).map(CarName::new).collect(Collectors.toList())
        );
    }

    @Override
    public void close() {
        scanner.close();
    }
}
