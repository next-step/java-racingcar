package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionsTest {

    private List<Position> positionList;

    @DisplayName("Positions가 정상적으로 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 50, 100})
    void getPositionsTest(int count) {
        init(count);
        Positions positions = new Positions(positionList);
        assertThat(positions.getPositions()).hasSize(count);
        for (int position : positions.getPositions()) {
            assertThat(position).isEqualTo(0);
        }
    }

    void init(int count) {
        positionList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            positionList.add(new Position());
        }
    }
}