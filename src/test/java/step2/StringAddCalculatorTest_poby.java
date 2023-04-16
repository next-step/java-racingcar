package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.StringAddCalculator_poby.*;

public class StringAddCalculatorTest_poby {

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAddSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 콜론구분자() {
        assertThat(splitAddSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 컴마구분자() {
        assertThat(splitAddSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(splitAddSum("1")).isEqualTo(1);
    }

    //테스트 케이스의 의도를 드러내는게 가장 중요 >> 메소드명을 한글로 하는것도 굳
    //그래서 한글로 의미를 나타냈는데 굳이 DisplayName을 쓸 필요는 없음
    @Test
    void 빈문자열_null() {
        assertThat(splitAddSum(null)).isEqualTo(0);
        assertThat(splitAddSum("")).isEqualTo(0);
    }
}