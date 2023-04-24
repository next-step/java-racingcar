package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingGameTest {

    @Test
    void play() {
        CarRacingGame game = new CarRacingGame(new String[]{"pobi", "crong", "honux"});
        assertThatThrownBy(() -> game.play(0)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("최소 한 번이상 시도해야합니다.");
    }

    @Test
    @DisplayName("우승자들의 현위치가 최대거리가 맞는지 확인")
    void getWinners() {
        CarRacingGame game = new CarRacingGame(new String[]{"pobi", "crong", "honux"});
        game.play(4);

        List<Car> winners = game.getWinners();
        int maxDistance = winners.get(0).getLocation();
        assertThat(winners.stream().allMatch(car -> car.isLocated(maxDistance))).isTrue();

        List<Car> cars = game.getCars();
        assertThat(cars.stream().allMatch(car -> car.getLocation() <= maxDistance)).isTrue();
    }
}
