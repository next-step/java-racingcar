package step3.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.study.dto.RequestRacingDTO;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DriversTest {
    private RequestRacingDTO requestRacingDTO;
    private Drivers drivers;

    @BeforeEach
    void setUp() {
        String[] names = {"pobi", "crong", "honux"};
        int tryCount = 3;
        requestRacingDTO = new RequestRacingDTO(names, tryCount);
        drivers = new Drivers(Drivers.of(requestRacingDTO));
    }

    @Test
    @DisplayName("우승자 테스트")
    void getWinnerNames() {
        drivers.getDriverList().get(0).moveCar(4);
        assertThat(drivers.getWinnerNames().size()).isEqualTo(1);
        assertThat(drivers.getWinnerNames().contains("pobi")).isTrue();

    }
}
