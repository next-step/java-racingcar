package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("레이스를 시작하면 레이스에 필요한 세팅 성공")
    void createRace() {
        Race mockRace = new Race();

        int mockCars = 2;
        int mockRounds = 3;

        mockRace.setUpRace(mockCars, mockRounds);

        assertThat(mockRace.getCars().size()).isEqualTo(2);
        assertThat(mockRace.getNumOfRounds()).isEqualTo(3);
    }
}
