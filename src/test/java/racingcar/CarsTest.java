package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("경주의 최소 차량 조건을 충족한다.")
    @Test
    void Cars_경주조건_충족() {
        Cars cars = new Cars(Racing.MINIMUM_CAR_COUNT);
        assertThat(cars.carsReady(Racing.MINIMUM_CAR_COUNT)).isTrue();
    }

    @DisplayName("구분된 문자열을 이름으로 문자열 개수만큼 자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,jh,choi", "choi", "mon, fri, sat, sun"})
    void Cars_레이서_인원만큼_Car_생성(String input) {
        Cars cars = new Cars(input);

        String[] racerNames = RacerNameValidator.splitByComma(input);
        assertThat(cars.size()).isEqualTo(racerNames.length);

        for (String name : racerNames) {
            assertThat(cars.isParticipate(name)).isTrue();
        }
    }

    @DisplayName("가장 빠른사람이 한 명 일떄 이름을 리턴한다.")
    @Test
    void Cars_가장_빠른_레이서() {
        Car movableCar = new Car("a", () -> true);
        movableCar.move();
        Car pauseCar = new Car("b", () -> false);
        Cars cars = new Cars();
        cars.add(movableCar);
        cars.add(pauseCar);

        assertThat(cars.mostFastest()).isEqualTo("a");
    }

    @DisplayName("가장 빠른사람이 한 명 이상일떄 이름을 쉼표(,)로 구분해서 리턴한다.")
    @Test
    void Cars_가장_빠른_레이서들() {
        Car movableCar = new Car("a", () -> true);
        movableCar.move();
        Car pauseCar = new Car("b", () -> true);
        pauseCar.move();
        Cars cars = new Cars();
        cars.add(movableCar);
        cars.add(pauseCar);

        assertThat(cars.mostFastest()).isEqualTo("a,b");
    }
}