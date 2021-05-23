package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadyTest {
    private Ready ready = new Ready();

    @Test
    @DisplayName("선수 목록 만들기")
    void TestCreatePlayerList() {
        // when
        String name = "s,h,j";

        // given
        String[] expected = {"s","h","j"};
        String[] actual = ready.createPlayerList(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("숫자가 5초과 인지 확인")
    void TestisGreaterThanFive() {
        // when
        int number = 6;

        // given
        boolean actual = ready.isGreaterThanFive(number);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("숫자가 5이하 인지 확인")
    void TestisNotMoreThanFive() {
        // when
        int number = 3;

        // given
        boolean actual = ready.isGreaterThanFive(number);

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("정상 테스트 : 이름의 길이가 5이하 인지 확인")
    void TestCheckNameLength() {
        // when
        String name = "tomas";

        // given
        String actual = ready.checkNameLength(name);

        // then
        assertThat(actual).isEqualTo(name);
    }

    @Test
    @DisplayName("예외 테스트 : 이름의 길이가 5초과 인지 확인")
    void ExceptionTestCheckNameLength() {
        // when
        String name = "tomato";

        // then
        assertThatIllegalArgumentException().isThrownBy(()
                -> ready.checkNameLength(name));
    }
}
