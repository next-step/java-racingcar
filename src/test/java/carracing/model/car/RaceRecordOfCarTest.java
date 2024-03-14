package carracing.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class RaceRecordOfCarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "2:2:true", "3:3:true", "3:1:false", "10:11:false"}, delimiter = ':')
    @DisplayName("samePosition(): 멤버 변수인 position이 함수 파라미터를 통해 주어진 값과 동일하면 true 그렇지 않으면 false를 반환한다.")
    void testSamePosition(int position, int givenPosition, boolean expected) {
        RaceRecordOfCar raceRecordOfCar = RaceRecordOfCar.newRaceRecord("car", position, Collections.emptyList());
        assertThat(raceRecordOfCar.samePosition(givenPosition)).isEqualTo(expected);
    }
}