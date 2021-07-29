package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionsTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    @DisplayName("Positions 렌더링 테스트")
    @Test
    public void positionsRenderTest() {
        int[] mockPositions = new int[] {3, 1, 2};
        Positions positions = Positions.of(createPositions(mockPositions));
        assertThat(positions.render())
                .isEqualTo(expected(mockPositions));
    }

    private String expected(int[] mockPositions) {
        return Position.of(mockPositions[0]).render() + NEW_LINE +
                Position.of(mockPositions[1]).render() + NEW_LINE +
                Position.of(mockPositions[2]).render();
    }

    private List<Position> createPositions(int[] mockPositions) {
        List<Position> positions = new ArrayList<>();
        positions.add(Position.of(mockPositions[0]));
        positions.add(Position.of(mockPositions[1]));
        positions.add(Position.of(mockPositions[2]));
        return positions;
    }

}