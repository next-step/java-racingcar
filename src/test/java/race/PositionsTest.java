package race;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionsTest {
    @Test
    void int형_List와_동일한지_비교할_수_있다() {
        Positions positions = new Positions(List.of(new Position()));
        assertThat(positions).isEqualTo(List.of(0));
    }
}
