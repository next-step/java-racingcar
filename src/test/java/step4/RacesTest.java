package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Car;
import step4.model.Races;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacesTest {

    @ParameterizedTest
    @CsvSource(value = "jane,john", delimiter = ',')
    @DisplayName("레이스가 생성되면 넘겨받은 자동차 이름 갯수만큼 Car 객체가 생성된다.")
    void raceGenerateTest(String janeCar, String johnCar) {
        Races races = new Races(Arrays.asList(janeCar, johnCar));
        assertThat(races.getCars()).size().isEqualTo(2);
    }

    @Test
    @DisplayName("레이스가 정상적으로 실행되는지 확인한다.")
    void raceStartTest() {
        Races races = mock(Races.class);
        races.start(true);
        verify(races, times(1)).start(true);
    }

    @Test
    @DisplayName("레이싱이 완료 된 자동차 리스트를 받아 우승자를 정한다.")
    void getWinnersTest() {
        Races racing = new Races(List.of("jane", "john"));
        racing.start(true);
        assertThat(racing.getWinners().stream().map(Car::getName).collect(Collectors.joining()))
                .isEqualTo("jane");
    }

    @Test
    @DisplayName("레이싱이 완료 된 자동차 리스트를 받아 우승자가 2명 이상이라면 두명 다 조회된다.")
    void getMultipleWinnersTest() {
        Races racing = new Races(List.of("jane", "john"));
        racing.start(true);
        assertThat(racing.getWinners().stream().map(Car::getName).collect(Collectors.joining(",")))
                .isEqualTo("jane,john");
    }
}
