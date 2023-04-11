package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void 입력된_값에따라_객체_생성(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        Map<Integer, AtomicInteger> cars = Car.generateCars(i);

        assertThat(cars.size()).isEqualTo(i);
    }

    @Test
    void 랜덤_생성_숫자가_4보다_큰지_작은지() {
        int randomNumber = Car.generateRandomNumber();
        boolean isOverFour = randomNumber >= Car.RANDOM_NUMBER_LIMIT;
        if (isOverFour) {
            assertThat(randomNumber).isGreaterThanOrEqualTo(Car.RANDOM_NUMBER_LIMIT);
        } else {
            assertThat(randomNumber).isLessThanOrEqualTo(Car.RANDOM_NUMBER_LIMIT);
        }
    }

}
