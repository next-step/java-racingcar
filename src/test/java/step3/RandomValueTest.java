package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RandomValueTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("0~9 범위가 아닌 숫자로 랜덤값 객체 생성시 IllegalArgumentException가 발생하는지 확인한다.")
    void illegalArgument(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> {
                            RandomValue randomValue = new RandomValue(number);
                        }
                );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    @DisplayName("0~9 범위인 숫자로 랜덤값 객체 생성시 정상적으로 객체가 생성되는지 확인한다.")
    void legalArgument(int number) {
        RandomValue randomValue = new RandomValue(number);
        assertThat(randomValue.equals(new RandomValue(number))).isTrue();
    }

    @Test
    @DisplayName("RandomValue의 속성인 value가 4이상의 숫자이면 성공, 아니면 실패인지 확인한다 ")
    void meet() {
        assertThat(new RandomValue(5).meet(4)).isTrue();
        assertThat(new RandomValue(1).meet(4)).isFalse();
    }
}