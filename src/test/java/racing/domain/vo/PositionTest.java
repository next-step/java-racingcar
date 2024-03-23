package racing.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    void createPositionTest(){
        Position position = new Position(3);
        assertThat(position.getNumber()).isEqualTo(3);
    }
}
