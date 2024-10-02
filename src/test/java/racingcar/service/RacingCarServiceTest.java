package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    public void generateRandomNumberForMovingCarTest() {
        int[] randomNumbers = racingCarService.generateRandomNumberForMovingCar(3);

        for(int carNumber : randomNumbers) {
            assertThat(carNumber).isBetween(1, 9);
        }
    }

    @Test
    public  void IsMovingForwardTest() {
        boolean[] carForwardStatuses = racingCarService.IsMovingForward(racingCarService.generateRandomNumberForMovingCar(3));

        for(boolean carForwardStatus : carForwardStatuses) {
            assertThat(carForwardStatus).isIn(true, false);
        }
    }


    @Test
    public void saveCarMovementStatusesTest() {
        // carMovementStatuses 초기화
        Map<Integer, String> carMovementStatuses = racingCarService.getCarMoveStatuses(); // 초기 상태 설정

        // 첫 번째 테스트: 첫 호출
        boolean[] carForwardStatuses1 = {true, false, true};
        racingCarService.saveCarMovementStatuses(carForwardStatuses1);

        // 상태 검증
        assertThat(carMovementStatuses.get(0)).isEqualTo("-"); // 첫 번째 자동차는 전진했으므로 "-"
        assertThat(carMovementStatuses.get(1)).isEqualTo(""); // 두 번째 자동차는 전진하지 않았으므로 "-"
        assertThat(carMovementStatuses.get(2)).isEqualTo("-"); // 세 번째 자동차는 전진했으므로 "-"

        // 두 번째 테스트: 두 번째 호출
        boolean[] carForwardStatuses2 = {false, true, true};
        racingCarService.saveCarMovementStatuses(carForwardStatuses2);

        // 상태 검증
        assertThat(carMovementStatuses.get(0)).isEqualTo("-"); // 첫 번째 자동차는 여전히 "-"
        assertThat(carMovementStatuses.get(1)).isEqualTo("-"); // 두 번째 자동차는 전진했으므로 "-" 추가
        assertThat(carMovementStatuses.get(2)).isEqualTo("--"); // 세 번째 자동차는 전진했으므로 "-" 추가
    }
}
