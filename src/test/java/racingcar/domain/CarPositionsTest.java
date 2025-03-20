package racingcar.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionsTest {
    @Test
    @DisplayName("CarPositions 객체 생성 후 위치 리스트 크기를 확인한다")
    void addPosition() {
        List<CarPosition> positions = List.of(new CarPosition("onion",2),
            new CarPosition("rice", 1),
            new CarPosition("musi", 3));

        CarPositions carPositions = new CarPositions(positions);

        assertThat(carPositions.getPositions().size()).isEqualTo(3);
    }
}
