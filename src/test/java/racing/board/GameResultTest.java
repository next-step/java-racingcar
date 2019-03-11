package racing.board;

import org.junit.*;
import racing.model.CarDto;
import racing.model.NamedRacingCar;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class GameResultTest {

    @Test
    public void test_추가_2스텝() {
        // Given
        GameResult gameResult = new GameResult();

        // When
        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar());

        // Then
        assertThat(gameResult.addStep(cars))
                .isEqualTo(1);
        assertThat(gameResult.addStep(cars))
                .isEqualTo(2);
    }


    @Test
    public void test_우승_1대() {
        // Given
        GameResult gameResult = new GameResult();
        RacingCar winner = new RacingCar();

        // When
        winner.move(RacingCar.THRESHOLD_POWER);
        gameResult.addStep(Arrays.asList(new RacingCar(), winner));

        // Then
        List<String> winnerNames = Arrays.asList(winner.mapToDto().getName());
        assertThat(gameResult.winners())
                .isEqualTo(winnerNames);
    }

    @Test
    public void test_우승_2대() {
        // Given
        GameResult gameResult = new GameResult();
        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar(), new RacingCar());
        List<RacingCar> winners = cars.subList(0, 2);

        // When
        winners.forEach(car -> car.move(RacingCar.THRESHOLD_POWER));
        gameResult.addStep(cars);

        // Then
        List<String> winnerNames = winners
                .stream()
                .map(car -> car.mapToDto().getName())
                .collect(Collectors.toList());

        assertThat(gameResult.winners())
                .isEqualTo(winnerNames);
    }
}