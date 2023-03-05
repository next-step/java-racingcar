package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarRaceTest {

    @ParameterizedTest
    @ValueSource(strings={"aaa","cartest222","aaabb"}) //총 3번실행됨
    void contains(final String  strings) { //입력받은 문자 값 비교
        int maxSize = 5;
        if (strings.length() > maxSize) {
            // 예외 발생
            throw new IllegalArgumentException("문자열 길이가 " + maxSize + "자를 초과하였습니다.");
        }
    }
    @Test
    void pickRandom() {
        Random random = new Random();
        int next = random.nextInt(10);
        int actual = 0;
        if (next >= 4) {
            actual = 1;
            assertThat(actual).isEqualTo(1);
        }
        if (next < 4) {
            actual = 0;
            assertThat(actual).isEqualTo(0);
        }

    }


}
