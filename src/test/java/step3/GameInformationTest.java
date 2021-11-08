package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameInformationTest {


    @DisplayName("getTime 는 RuleDto의 time을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"kay,may:3:3", "kay,may:6:6"}, delimiter = ':')
    void getTimeTest(String namesStr, Integer time, Integer expectTime) {
        GameInformation gameInformation = GameInformation.create(namesStr, time);

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }

    @DisplayName("from() 메서드는 정상적으로 RuleDto를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"kay,may:3:4:3", "kay,may:6:5:6"}, delimiter = ':')
    void getTimeTest(String namesStr, Integer time, Integer expectCount, Integer expectTime) {
        GameInformation gameInformation = GameInformation.create(namesStr, time);

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }


}