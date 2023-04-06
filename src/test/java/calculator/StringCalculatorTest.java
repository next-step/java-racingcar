package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
/**
 * calculator 패키지 안 파일들은 줌 강의를 보고 학습용으로 작성한 내용입니다.
 */
public class StringCalculatorTest {
    /**
     * 테스트 케이스의 의도를 나타내는 것이 중요하다.
     * production code를 한국어로 적으면 없어보이지만,
     * 의도를 잘 들어내는 것이 중요하기 때문에 한글로 적는것도 좋은 방법이다.
     *
     * displayname 또한 정성들여 작성할 필요 없다.
     * 너무 input과 output값에 의존적으로 만들면 데이터 값이 바뀌면 같이 바뀌어야 하므로
     * 유지보수하기에 어렵다.
     */
    @Test
    @DisplayName("빈문자열 또는 null 값 체크")
    void 빈문자열_null() {
        int actual = splitAndSum(null);    //잘 모르겠으면 클래스 메서드로 구현하라.
        int actual2 = splitAndSum("");
        assertThat(actual).isEqualTo(0);
        assertThat(actual2).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 컴마구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }
    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }
}
