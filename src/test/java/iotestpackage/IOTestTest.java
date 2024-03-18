package iotestpackage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class IOTestTest extends IOTest {
    @Test
    void set_in_test() {
        systemIn("원하는 입력값");
        test();

        Assertions.assertThat(getOutput()).contains("원하는 입력값");
    }

    void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}
