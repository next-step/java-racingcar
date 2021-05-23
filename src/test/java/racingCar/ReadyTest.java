package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("숫자가 5이상 인지 확인")
    void TestisGreaterThanFive() {
        // when
        int number = 5;

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

}
