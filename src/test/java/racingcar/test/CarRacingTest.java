package racingcar.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.RacingRepository;
import racingcar.service.RacingService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    private static RacingRepository racingRepository;
    private static RacingService racingService;

    @BeforeAll
    public static void setting() {
        racingRepository = new RacingRepository();
        racingService = new RacingService(racingRepository);
    }


    @Test
    @DisplayName("전체 시도횟수")
    public void totalTry() {
        int cnt = 10;

        racingService.totalTry(cnt);
        assertThat(racingRepository.getTotalTry()).isEqualTo(10);
    }

    @Test
    @DisplayName("전체 차량 수")
    public void Cars() {
        List<Car> equals = new ArrayList<>();
        equals.add(new Car());
        equals.add(new Car());
        equals.add(new Car());

        racingService.makeCars(3);

        assertThat(racingRepository.cars.size()).isEqualTo(equals.size());
    }

}