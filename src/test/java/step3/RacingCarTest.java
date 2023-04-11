package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void 입력된_값에따라_객체_생성(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        Map<Integer, AtomicInteger> cars = Car.generateCars(i);

        Assertions.assertThat(cars.size()).isEqualTo(i);
    }

}
