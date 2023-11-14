package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.controller.ChampionCarsDto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRacingPlayTest {

    @Test
    @DisplayName("자동차 경주할 차들을 세팅하지 않고 raceOneCycle 메서드를 호출하면 에러를 발생시킵니다.")
    void withOutSettingCars() {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator());
        // when
        // then
        assertThatThrownBy(carRacingPlay::raceOneCycle)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("먼저 경주에 참여할 자동차를 정의해야 합니다.");
    }

    @Test
    @DisplayName("스트링으로 된 자동차 이름들을 입력받으면 자동차 인스턴스를 갖는 리스트를 생성해줍니다.")
    void construct() {
        // given
        // when
        CarRacingPlay carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator());
        carRacingPlay.makeRacingCars(List.of("car1", "car2", "car3"));

        // then
        assertThat(carRacingPlay.getCars()).hasSize(3)
                .extracting("name", "distance")
                .containsExactly(
                        tuple("car1", 0),
                        tuple("car2", 0),
                        tuple("car3", 0)
                );
    }

    @ParameterizedTest(name = "랜점 숫자가 0 ~ 3 이하인 경우 차량은 움직이지 않습니다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void doNotMoveOneCycle(int randomValue) {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(() -> randomValue);
        carRacingPlay.makeRacingCars(List.of("test"));
        // when
        List<Car> cars = carRacingPlay.raceOneCycle();
        // then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).toString()).isEqualTo("test : ");
    }

    @ParameterizedTest(name = "랜점 숫자가 4 ~ 9 이하인 경우 차량은 1칸 움직입니다.")
    @ValueSource(ints = {4, 7, 9})
    void moveOneCycle(int randomValue) {
        // given
        CarRacingPlay carRacingPlay = new CarRacingPlay(() -> randomValue);
        carRacingPlay.makeRacingCars(List.of("test"));
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
        });

        carRacingPlay.makeRacingCars(List.of("test1", "test2", "test3"));
        carRacingPlay.raceOneCycle();

        // when
        ChampionCarsDto championsDto = carRacingPlay.findChampions();

        // then
        assertThat(championsDto.toString()).isEqualTo(new ChampionCarsDto(List.of(Car.makeCar("test2"), Car.makeCar("test3"))).toString());
    }
}