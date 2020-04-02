package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PositionTest {

    @DisplayName("동일한 매개변수를 전달하면 같은 것으로 비교한다")
    @Test
    public void constructor_success() throws Exception {
        //given
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        //then
        assertThat(position1.equals(position2)).isTrue();
    }

    @DisplayName("거리를 한칸 이동 한다")
    @Test
    public void move_success() throws Exception {
        //given
        Position position = Position.getInstance();
        Position compare = new Position(1);

        //when
        position = position.move();

        //then
        assertThat(position.equals(compare)).isTrue();
    }

    @DisplayName("멤버 변수를 이용하여 크기를 비교 한다")
    @ParameterizedTest
    @CsvSource(value = {"10:20:-1", "20:10:1", "10:10:0"}, delimiter = ':')
    public void compare_success(int range1, int range2, int expect) throws Exception {
        //given
        Position position1 = new Position(range1);
        Position position2 = new Position(range2);

        //when
        int compare = position1.compareTo(position2);

        //then
        assertThat(compare).isEqualTo(expect);
    }

    @DisplayName("0 이하의 포지션으로 초기화 하면 exception")
    @Test
    public void constructor_fail() throws Exception {
        assertThatThrownBy(
                () -> assertThat(new Position(-1))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

