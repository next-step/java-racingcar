package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @Test
    @DisplayName("레이싱카 객체를 원하는 만큼 생성하는 메서드 테스트")
    void createRacingCars() {
        RacingService racingService = new RacingService();
        List<RacingCar> racingCars = racingService.createRacingCars(3);

        assertThat(racingCars).hasSize(3);

    }

}
