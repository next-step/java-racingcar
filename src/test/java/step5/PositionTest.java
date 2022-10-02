package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void Position_생성_및_비교_테스트(){
        assertThat(new Position(5)).isEqualTo(new Position(5));
        assertThat(new Position(5)).isNotEqualTo(new Position(6));
    }

    @Test
    void Position_이동_테스트(){
        assertThat(new Position(5).nextPosition()).isEqualTo(new Position(6));
    }


}
