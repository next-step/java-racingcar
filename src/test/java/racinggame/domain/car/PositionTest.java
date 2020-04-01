package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Position position = new Position();
        Position compare = new Position(1);

        //when
        position = position.move();

        //then
        assertThat(position.equals(compare)).isTrue();
    }

    @DisplayName("멤버 변수를 이용하여 크기를 비교 한다")
    @Test
    public void compare_success() throws Exception {
        //given
        Position position1 = new Position(10);
        Position position2 = new Position(20);

        //when
        int i = position1.compareTo(position2);

        //then
        assertThat(i).isEqualTo(-1);
    }
}

