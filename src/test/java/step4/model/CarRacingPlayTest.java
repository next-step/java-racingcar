package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRacingPlayTest {

    @ParameterizedTest(name = "랜점 숫자가 0 ~ 3 이하인 경우 차량은 움직이지 않습니다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void doNotMoveOneCycle(int randomValue) {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(() -> randomValue, List.of("test"));
        // when
        List<Car> cars = carRacingPlay.raceOneCycle();
        // then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).toString()).isEqualTo("test : ");
    }

    @ParameterizedTest(name = "랜점 숫자가 4 ~ 9 이하인 경우 차량은 움직이지 않습니다.")
    @ValueSource(ints = {4, 7, 9})
    void moveOneCycle(int randomValue) {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(() -> randomValue, List.of("test"));
        // when
        List<Car> cars = carRacingPlay.raceOneCycle();
        // then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).toString()).isEqualTo("test : -");
    }

    @Test
    @DisplayName("distance 가 가장 높은 우승자 자동차 리스트를 반환합니다.")
    void findChampions() {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(new RandomValueGenerator() {
            private final int[] randoms = {1, 4, 9};
            private int count = 0;

            @Override
            public int generateRandomValue() {
                int random = randoms[count % 3];
                count ++;
                return random;
            }
        }, List.of("first", "second", "third"));

        carRacingPlay.raceOneCycle();

        // when
        ChampionCarsDto championsDto = carRacingPlay.findChampions();
        List<Car> champions = championsDto.getCars();
        // then
        assertThat(champions).hasSize(2);
        assertThat(champions)
                .extracting("name", "distance")
                .containsExactly(
                        tuple("second", 1),
                        tuple("third", 1)
                );
    }

}