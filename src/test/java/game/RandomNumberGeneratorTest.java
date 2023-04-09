package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("100회 정도의 난수를 통해 해당 범위만 가져오는지 확인합니다.")
    void test01() {
        int min = 10;
        int max = 100;

        RandomNumberGenerator generator = generator(min, max);
        int[] results = new int[100];
        for (int i = 0; i < 100; i++) {
            results[i] = generator.getNumber();
        }

        for (int num : results) {
            System.out.println(num);
            assertThat(isValidRange(min, max, num)).isTrue();
        }
    }

    private boolean isValidRange(int min, int max, int num) {
        return min <= num && num <= max;
    }

    public RandomNumberGenerator generator(int min, int max) {
        return RandomNumberGenerator.range()
                .min(min)
                .max(max);
    }

    @Test
    @DisplayName("랜덤 숫자 생성기의 범위를 잘 못 지정하면 예외가 발생합니다.")
    void test02() {
        RandomNumberGenerator generator = generator(10, 1);
        assertThatThrownBy(generator::getNumber)
                .isInstanceOf(IllegalStateException.class);
    }
}