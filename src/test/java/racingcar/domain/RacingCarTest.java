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

    @DisplayName("RacingCar 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"볼보:3", "폭스바겐:5", "벤츠:7"}, delimiter = ':')
    public void movePosition(String carName, int expectedMove) {
        //Given
        RacingCar racingCar = new RacingCar(carName);
        Commander commander = () -> true;

        //When
        IntStream.range(0, expectedMove -1 )
                .forEach(i -> racingCar.move(commander));

        //Then
        assertThat(racingCar).isEqualTo(new RacingCar(carName, expectedMove));
    }


    @DisplayName("RacingCar Equals 테스트")
    @ParameterizedTest
    @CsvSource(value = {"현대:현대:현대", "kia:kia:kia", "volvo:volvo:volvo"}, delimiter = ':')
    public void carNameInstanceEqualsTest(String carName, String carName2, String carName3) {

        //Given && When
        RacingCar car1 = new RacingCar(carName, 5);
        RacingCar car2 = new RacingCar(carName2, 5);
        RacingCar car3 = new RacingCar(carName3, 5);

        //Then
        assertThat(car1).isEqualTo(car2).isEqualTo(car3);
    }

    @DisplayName("RacingCar hashCode 테스트")
    @ParameterizedTest
    @CsvSource(value = {"현대:현대", "기아:기아", "제네시스:제네시스"}, delimiter = ':')
    public void carNameHashCodeTest(String carName, String carName2) {
        //Given & When
        Map<RacingCar, Boolean> map = new HashMap<>();
        map.put(new RacingCar(carName, 5), true);
        map.put(new RacingCar(carName2, 5), false);

        //Then
        assertThat(map.get(new RacingCar(carName, 5))).isFalse();
    }

    @DisplayName("RacingCar 이름 유효성 검사 테스트")
    @ParameterizedTest
    @CsvSource(value = {"람보르기니기니", "폭스바겐바겐", "제네시스시스"})
    public void inValidCarName(String carName){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingCar car = new RacingCar(carName);
                }).withMessage("자동차 이름에 빈값은 사용할 수 없으며, 5자를 넘을 수 없습니다.");
    }
}