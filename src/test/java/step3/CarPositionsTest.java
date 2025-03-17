package step3;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionsTest {
    @Test
    void addPosition() {
        List<String> positions = List.of("-", "", "--");
        CarPositions carPositions = new CarPositions(positions);

        assertThat(carPositions.getPositions().size()).isEqualTo(3);
    }
}