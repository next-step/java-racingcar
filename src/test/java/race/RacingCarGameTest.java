package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {


    @Test
    @DisplayName("모두 이동하지 않는 경우 공동 우승자가 된다.")
    public void pickRaceWinner() {
        List<String> carNames = List.of("test1", "test2");
        RacingCarGame racingCarGame = new RacingCarGame(carNames, 2);

        List<RacingCar> winners = racingCarGame.findWinners();

        assertThat(winners.size()).isEqualTo(2);

    }
    @Test
    @DisplayName("특정 차량이 앞서있는 경우 해당 차량이 우승자가 된다.")
    public void pickRaceWinner1() {
        List<String> carNames = List.of("test1", "test2");
        FakeRandom fakeRandom = new FakeRandom(4);
        NumberPicker numberPicker = new NumberPicker(fakeRandom);

        List<RacingCar> racingCars = carNames.stream()
                .map(name -> new RacingCar(name, numberPicker))
                .collect(Collectors.toList());

        RacingCarGame racingCarGame = new RacingCarGame(racingCars);

        RacingCar racingCar = racingCars.get(0);
        racingCar.moveForward();
        racingCar.moveForward();

        List<RacingCar> winners = racingCarGame.findWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).extracting(RacingCar::getName).containsExactly("test1");
    }
}
