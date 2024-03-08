package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void addOne() {
        Position position1 = new Position();
        position1.addOne();

        Position position2 = new Position();
        position2.addOne();

        Position position3 = new Position();
        position3.addOne();
        position3.addOne();

        assertThat(position1).isEqualTo(position2);
        assertThat(position1).isNotEqualTo(position3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    void dashOfPosition(int input, String dash) {
        Position position = getPositionAdded(input);
        assertThat(position.dashOfPosition()).isEqualTo(dash);
    }

    private Position getPositionAdded(int addCount) {
        Position position = new Position();
        for (int i = 0; i < addCount; i++) {
            position.addOne();
        }

        return position;
    }
}