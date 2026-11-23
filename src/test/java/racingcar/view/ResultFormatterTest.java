package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultFormatterTest {
    private static final CarName POBI = new CarName("pobi");
    private static final CarName CRONG = new CarName("crong");
    private static final CarName HONUX = new CarName("honux");

    @ParameterizedTest
    @CsvSource(value = {"0:'pobi : '", "1:'pobi : -'", "3:'pobi : ---'"}, delimiter = ':')
    @DisplayName("차 하나의 진행상태를 이름과 위치만큼의 '-'로 표시한다")
    void formatCar(int position, String expected) {
        assertThat(ResultFormatter.formatCar(new Car(POBI, position))).isEqualTo(expected);
    }

    @Test
    @DisplayName("한 회차의 진행상태를 차마다 한 줄씩 표시한다")
    void formatRound() {
        Cars cars = new Cars(List.of(new Car(POBI, 2), new Car(CRONG, 0), new Car(HONUX, 1)));

        assertThat(ResultFormatter.formatRound(cars))
                .isEqualTo("pobi : --" + System.lineSeparator()
                        + "crong : " + System.lineSeparator()
                        + "honux : -");
    }

    @Test
    @DisplayName("우승자가 한 명이면 이름만 표시한다")
    void formatSingleWinner() {
        assertThat(ResultFormatter.formatWinners(List.of(POBI)))
                .isEqualTo("pobi가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("우승자가 여럿이면 쉼표로 구분해 표시한다")
    void formatMultipleWinners() {
        assertThat(ResultFormatter.formatWinners(List.of(POBI, HONUX)))
                .isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}
