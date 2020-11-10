package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {


    @DisplayName("RacingCar 객체 초기화 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"볼보", "폭스바겐", "벤츠"})
    public void createRacingCarInstanceTest(String carName) {
        //Given & When
        RacingCar racingCar = new RacingCar(carName);

        assertThat(racingCar.getCarName()).isEqualTo(carName);
        assertThat(racingCar.getCurrentPosition()).isEqualTo(1);
    }

    @DisplayName("RacingCar")
    @ParameterizedTest
    @CsvSource(value = {"볼보", "폭스바겐", "벤츠"})
    public void movePosition(String carName) {
        //Given
        RacingCar racingCar = new RacingCar(carName);
        Commander commander = () -> true;
        int range = 10;

        //When
        IntStream.range(0, range -1)
                .forEach(i -> racingCar.move(commander));
        //Then
        assertThat(racingCar.getCurrentPosition()).isEqualTo(range);
    }


    @DisplayName("RacingCar Equals 테스트")
    @ParameterizedTest
    @CsvSource(value = {"현대:현대:현대", "kia:kia:kia", "volvo:volvo:volvo"}, delimiter = ':')
    public void carNameInstanceEqualsTest(String carName, String carName2, String carName3) {

        //Given && When
        RacingCar car1 = new RacingCar(carName);
        RacingCar car2 = new RacingCar(carName2);
        RacingCar car3 = new RacingCar(carName3);

        //Then
        assertThat(car1).isEqualTo(car2).isEqualTo(car3);
    }

    @DisplayName("RacingCar hashCode 테스트")
    @ParameterizedTest
    @CsvSource(value = {"현대:현대", "기아:기아", "제네시스:제네시스"})
    public void carNameHashCodeTest(String carName) {
        //Given & When
        Map<RacingCar, Boolean> map = new HashMap<>();
        map.put(new RacingCar(carName), true);
        map.put(new RacingCar(carName), false);

        //Then
        assertThat(map.get(new RacingCar(carName))).isFalse();
    }

    @DisplayName("RacingCar hashCode 테스트")
    @ParameterizedTest
    @CsvSource(value = {"람보르기니기니", "폭스바겐바겐", "제네시스시스"})
    public void inValidCarName(String carName){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingCar car = new RacingCar(carName);
                }).withMessage("자동차 이름에 빈값은 사용할 수 없으며, 5자를 넘을 수 없습니다.");
    }
}