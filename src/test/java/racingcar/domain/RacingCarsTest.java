package racingcar.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름 문자 리스트로 생성시 정상적으로 생성되었는지 검증")
    void constructByNames() {
        then(
            new RacingCars(new String[]{"1", "2", "3", "4"})
        ).isEqualTo(
            new RacingCars(List.of(new RacingCar("1"), new RacingCar("2"), new RacingCar("3"), new RacingCar("4")))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("생성자에서 받은 racingCars List<RacingCar> 비어있는지 검증")
    void validateEmpty(List<RacingCar> racingCars) {
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(racingCars));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("생성자에서 받은 names String[] 비어있는지 검증")
    void validateEmpty(String[] names) {
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(names));
    }

    @Test
    @DisplayName("중복된 자동차 이름 검증")
    void validateDuplicateName() {
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(new String[]{"same", "same"}));
    }

    @Test
    void size() {
        then(new RacingCars(new String[]{"1", "2"}).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("RacingCars.move 에 넘긴 MoveCondition 리스트 상태에 맞게 이동하는지 Position 값으로 검증")
    void move() {
        RacingCar racingCar1 = new RacingCar("test1", 0);
        RacingCar racingCar2 = new RacingCar("test2", 1);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2));
        racingCars.move(List.of(() -> true, () -> true));
        then(racingCar1.getPosition()).isEqualTo(1);
        then(racingCar2.getPosition()).isEqualTo(2);

        racingCars.move(List.of(() -> true, () -> false));
        then(racingCar1.getPosition()).isEqualTo(2);
        then(racingCar2.getPosition()).isEqualTo(2);

        racingCars.move(List.of(() -> false, () -> false));
        then(racingCar1.getPosition()).isEqualTo(2);
        then(racingCar2.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("RacingCars.move 에 넘긴 MoveCondition 리스트 개수와 자동차 수가 맞는지 검증")
    void validateConditionsCount() {
        RacingCars racingCars = new RacingCars(new String[]{"1", "2"});
        assertThrows(IllegalArgumentException.class, () -> racingCars.move(List.of(() -> true)));
        assertThrows(IllegalArgumentException.class, () -> racingCars.move(List.of(() -> true, () -> false, () -> true)));
    }

    @Test
    @DisplayName("RacingCars 내의 자동차 모든 이름 반환 검증")
    void getAllNames() {
        RacingCars racingCars = new RacingCars(new String[]{"1", "2", "3"});
        then(racingCars.getAllNames()).isEqualTo(List.of("1", "2", "3"));
    }
}