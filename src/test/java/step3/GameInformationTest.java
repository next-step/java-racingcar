package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameInformationTest {

    @DisplayName("getCount 는 RuleDto의 count를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:3:4", "5:3:5"}, delimiter = ':')
    void getCountTest(Integer count, Integer time, Integer expectCount) {
        GameInformation gameInformation = GameInformation.create(count, time);

        assertThat(gameInformation.getCount()).isEqualTo(expectCount);
    }

    @DisplayName("getTime 는 RuleDto의 time을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:3:3", "5:6:6"}, delimiter = ':')
    void getTimeTest(Integer count, Integer time, Integer expectTime) {
        GameInformation gameInformation = GameInformation.create(count, time);

        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }

    @DisplayName("from() 메서드는 정상적으로 RuleDto를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:3:4:3", "5:6:5:6"}, delimiter = ':')
    void getTimeTest(Integer count, Integer time, Integer expectCount, Integer expectTime) {
        GameInformation gameInformation = GameInformation.create(count, time);

        assertThat(gameInformation.getCount()).isEqualTo(expectCount);
        assertThat(gameInformation.getTime()).isEqualTo(expectTime);
    }


}