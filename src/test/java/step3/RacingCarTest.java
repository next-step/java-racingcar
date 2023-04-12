package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;
import static step3.Car.*;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void 입력된_값에따라_객체_생성(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        Map<Integer, AtomicInteger> cars = generateCars(i);

        assertThat(cars.size()).isEqualTo(i);
    }

    @Test
    void 랜덤_생성_숫자가_4보다_큰지_작은지() {
        int randomNumber = generateRandomNumber();
        boolean isOverFour = randomNumber >= RANDOM_NUMBER_LIMIT;
        if (isOverFour) {
            assertThat(randomNumber).isGreaterThanOrEqualTo(RANDOM_NUMBER_LIMIT);
        } else {
            assertThat(randomNumber).isLessThanOrEqualTo(RANDOM_NUMBER_LIMIT);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 입력_숫자만큼_라운드를_반복함(int round) {
        int i = iteratePeriod(round, generateCars(round));
        assertThat(i).isEqualTo(round);
    }

    @Test
    void 음수입력시_예외처리() {
        String negative = "-1";
        InputStream in = new ByteArrayInputStream(negative.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        assertThatThrownBy(() -> Car.validatePositive(i)).isInstanceOf(RuntimeException.class).hasMessage("음수는 입력할 수 없습니다.");

    }

}
