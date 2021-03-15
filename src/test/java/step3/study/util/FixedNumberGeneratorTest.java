package step3.study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FixedNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    @DisplayName("고정숫자 생성 테스트")
    void createFixedNumberTest(int num) {
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(num);
        assertThat(fixedNumberGenerator.createNumber()).isEqualTo(num);
    }
}