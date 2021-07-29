package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTests {
    @Test
    @DisplayName("Position 원시값 포장 객체 create test")
    void create(){
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("-1 은 position 일 수 없으므로 처리해주는 테스트 test(원시값 포장 객체의 장점, 원시 값으로는 불가능하다!)")
    void valid(){
        assertThatThrownBy(() ->{
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("position 증가 test(getter setter 없애면 객체지향 적으로 메세지를 보낼 수 있다.)")
    void move(){
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }
}
