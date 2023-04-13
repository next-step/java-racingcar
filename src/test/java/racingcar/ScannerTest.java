package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class ScannerTest {

    @Test
    void 스캐너_문자열입력() {
        Scanner scanner = new Scanner("2");
        assertThat(scanner.nextInt()).isEqualTo(2);
    }

}
