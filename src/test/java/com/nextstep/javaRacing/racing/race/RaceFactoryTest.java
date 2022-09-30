package com.nextstep.javaRacing.racing.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,4", "5,6"})
    @DisplayName("생성자로 전달받은 입력으로 레이스를 생성한다")
    void prepareRace_with_number(int cars, int turns) {
        Race race = RaceFactory.prepareRace(cars, turns);
        assertThat(race.cars.size()).isEqualTo(cars);
        assertThat(race.turns).isEqualTo(turns);
    }

    @Test
    @DisplayName("자동차 이름을 콤마(,)로 분리하여 그 갯수만큼 Car를 생성한다")
    void prepareRace_with_name() {
        String carNames = "현대,기아,포르쉐,아우디,벤츠";
        Race race = RaceFactory.prepareRace(carNames, 1);
        assertThat(race.cars.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("이름은 최대 5자까지 입력할 수 있다")
    void prepareRace_too_long_name() {
        Race race = RaceFactory.prepareRace("현대기아차", 1);
        assertThat(race.cars.size()).isEqualTo(1);

        assertThatThrownBy(()->RaceFactory.prepareRace("현대기아자동차", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}