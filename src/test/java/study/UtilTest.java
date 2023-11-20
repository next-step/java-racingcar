package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.policy.RacingCarPolicy;
import study.util.RandomNumberGenerator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilTest {

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("scanner 동작 테스트")
    void scannerTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        assertThat(inputValue).isEqualTo("1");
    }

    @Test
    @DisplayName("0-9 사이의 랜덤 숫자를 생성한다.")
    void getRandom0To9NumberTest() {
        int randomNumber = RandomNumberGenerator.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3"})
    @DisplayName("0-3의 숫자인 경우 false를 반환한다.")
    void stopBooleanTest(int input) {
        boolean result = RacingCarPolicy.canMovingCar(input);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("4-9의 숫자인 경우 true를 반환한다.")
    void movingBooleanTest(int input) {
        boolean result = RacingCarPolicy.canMovingCar(input);
        assertThat(result).isTrue();
    }

}
