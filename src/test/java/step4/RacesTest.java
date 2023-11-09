package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Races;

import java.util.Arrays;

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

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("랜덤숫자를 넘긴다면 레이스가 시작된다.")
    void raceStartTest(int condition) {
        Races races = mock(Races.class);
        races.start(condition);
        verify(races, times(1)).start(condition);
    }
}
