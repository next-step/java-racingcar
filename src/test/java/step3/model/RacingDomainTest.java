package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDomainTest {

    @DisplayName("참가차량 명령어 값 셋팅 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:-", "3:-", "4:''", "5:''", "6:-"}, delimiter = ':')
    public void racingCarAddCommand(int entryNumber, String command){
        //Given
        RacingCar racingCar = new RacingCar(entryNumber);

        //When
        racingCar.addCommands(command);

        //Then
        assertThat(racingCar.getCommands().toString()).isNotNull();
    }

    @DisplayName("참가차량 entryNumber에 따른 equals 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void equalsTest(int entryNumber) {
        //Given & When
        RacingCar car = new RacingCar(entryNumber);
        RacingCar car2 = new RacingCar(entryNumber);

        //Then
        assertThat(car.equals(car)).isTrue();
        assertThat(car.equals(car2)).isTrue();
        assertThat(car2.equals(car)).isTrue();
        assertThat(car.equals(null)).isFalse();
    }

    @DisplayName("참가차량 hashcode 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "1:", "2:-", "2:", "3:-", "3:"}, delimiter = ':')
    public void hashCodeTest(int entryNumber, String command) {
        //Given
        Map<RacingCar, String> cars = new HashMap<>();

        //When
        cars.put(new RacingCar(entryNumber), command);

        //Then
        assertThat(cars.get(new RacingCar(entryNumber))).isEqualTo(command);
    }
}
