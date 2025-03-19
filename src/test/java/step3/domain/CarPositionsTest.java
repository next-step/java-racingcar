package step3.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionsTest {
    @Test
    @DisplayName("CarPositions 객체 생성 후 위치 리스트 크기를 확인한다")
    void addPosition() {
        List<String> positions = List.of("-", "", "--");
        CarPositions carPositions = new CarPositions(positions);

        assertThat(carPositions.getPositions().size()).isEqualTo(3);
    }
}