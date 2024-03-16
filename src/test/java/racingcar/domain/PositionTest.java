package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("현재 위치를 반환한다.")
    void getPosition() {
        //given
        Position position = new Position(4);

        //when & then
        assertThat(position.getPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("위치를 한칸 이동한다.")
    void increase() {
        //given
        int number = 0;
        Position position = new Position(number);

        //when
        position.increase();

        //then
        assertThat(position.getPosition()).isEqualTo(number + 1);
    }

    @Test
    @DisplayName("입력받은 수와 자신의 위치 중 더 큰 수를 반환한다.")
    void max() {
        //given
        int number = 4;
        Position position = new Position(number - 1);

        //when & then
        assertThat(position.max(number)).isEqualTo(number);
    }

    @Test
    @DisplayName("자신의 위치가 입력받은 위치인지 여부를 반환한다.")
    void isMatch() {
        //given
        int number = 4;
        Position position = new Position(number);

        //when && then
        assertThat(position.isMatch(number)).isTrue();
    }
}