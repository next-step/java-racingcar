package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    @DisplayName("포지션 생성 테스트")
    void positionTest(){
        Position position = new Position(3);
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("포지션 생성 테스트 실패")
    void positionCreateFailTest(){
        assertThatThrownBy(()->{
            Position position = new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("position 이동 테스트")
    void positionMoveTest(){
        Position position = new Position(4);
        position.move();
        assertThat(position).isEqualTo(new Position(5));
    }

    @Test
    @DisplayName("포지션이 최대값인지 테스트")
    void positionMaxValueTest(){
        Position position = new Position(4);
        assertThat(position.isMax(5)).isEqualTo(true);
    }

}
