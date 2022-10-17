package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("같은 이름 리스트로 생성한 cars는 항상 같아야 한다.")
    void namesOf_ShouldEqualWithSameNames() {
        Cars actual = Cars.namesOf(List.of("a", "b", "c"));

        assertThat(actual).isEqualTo(Cars.namesOf(List.of("a", "b", "c")));
    }

    @Test
    @DisplayName("5자 초과하는 이름이 하나라도 포함되면 자동차들 생성에 실패한다.")
    void namesOf_ShouldFailWhenANameOfNamesOver5() {
        assertThatThrownBy(() -> Cars.namesOf(List.of("abcdef", "b", "c")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");}

    @Test
    @DisplayName("레이스를 수행하면 position이 이동되어 있어야 한다.")
    void race() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));

        cars.race();

        assertThat(cars.getPositions()).isEqualTo(List.of(1, 1, 1));
    }

    @Test
    @DisplayName("a, b, c 위너 리스트를 반환해야한다.")
    void getWinners_ShouldReturnABCWinners() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));
        cars.race();

        List<String> actual = cars.getWinnerNames();

        assertThat(actual).isEqualTo(List.of("a", "b", "c"));
    }

    @Test
    @DisplayName("자동차리스트가 비어있는 경우 exception을 throw한다.")
    void getWinners_ShouldThrowExceptionWhenListEmpty() {
        Cars cars = Cars.namesOf(List.of());
        cars.race();

        assertThatThrownBy(cars::getWinnerNames)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("자동차가 존재하지 않습니다.");
    }
}
