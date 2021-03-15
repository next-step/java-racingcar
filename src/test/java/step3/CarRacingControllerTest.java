package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarRacingControllerTest {

    @DisplayName("자동차 경주를 시작하고 경주결과를 반환한다. 경주결과는 시도 횟수별 생성된 자동차의 수와 우승자를 반환한다.")
    @Test
    public void startCarRacing_ShouldReturnCarResultList() {
        String[] carsName = {"car1", "car2", "car3"};
        int roundCount = 5;

        CarRacingController carRacingController = new CarRacingController(new Round(roundCount),
                new CarRacing(carsName));
        List<CarResultDto> carResultDtoList = carRacingController.startCarRacing();

        assertThat(carResultDtoList.size()).isEqualTo(roundCount);
        assertThat(carResultDtoList).allSatisfy(carResultDto -> {
            assertThat(carResultDto.getCarDtoList().size()).isEqualTo(carsName.length);
            assertThat(carResultDto.getWinnerCarNames()).isNotEmpty();
        });
    }
}
