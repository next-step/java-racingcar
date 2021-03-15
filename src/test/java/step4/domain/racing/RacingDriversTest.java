package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.driver.Driver;
import step4.domain.request.Participants;
import step4.domain.startegy.move.MoveStrategy;
import step4.domain.startegy.name.NamingStrategy;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingDriversTest {

    private final int MINIMUM = 0;
    private final int MAXIMUM = 5;

    @DisplayName("RacingDriver 가 인자값으로 들어온 값을 알맞게 처리한 리스트를 만드는지에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 들어가는 값 : {arguments}")
    @CsvSource(value = {"a:1", "a,b:2", "a,b,c:3",}, delimiter = ':')
    void moveTest(String sentence, int expected) {
        // given
        NamingStrategy namingStrategy = name -> MINIMUM <= name.length() && name.length() <= MAXIMUM;
        MoveStrategy moveStrategy = () -> true;
        Participants participants = Participants.from(sentence.split(","));
        RacingDrivers racingDrivers = RacingDrivers.from(participants, namingStrategy);

        // when
        List<Driver> drivers = racingDrivers.move(moveStrategy, namingStrategy);
        int actual = drivers.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
