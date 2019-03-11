package racing.board;

import org.junit.*;
import racing.model.CarDto;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultOfStepByStepTest {

    @Test
    public void test_생성_스텝() {
        List<CarDto> result = Arrays.asList(new RacingCar().mapToDto());
        new GameResultOfStepByStep(result);
    }

    @Test
    public void test_getMaxPosition() {
        // Given
        RacingCar carHasMaxPosition = new RacingCar();
        int maxPosition = carHasMaxPosition.move(RacingCar.THRESHOLD_POWER);

        List<RacingCar> cars = Arrays.asList(carHasMaxPosition, new RacingCar(), new RacingCar());
        List<CarDto> carDtos = cars.stream().map(RacingCar::mapToDto).collect(Collectors.toList());

        // When
        GameResultOfStepByStep step = new GameResultOfStepByStep(carDtos);

        // Then
        assertThat(step.getMaxPosition()).isEqualTo(maxPosition);
    }
}