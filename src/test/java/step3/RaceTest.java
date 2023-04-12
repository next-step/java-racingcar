package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceTest {

    @DisplayName("레이싱 환경설정 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4", "11:12"}, delimiter = ':')
    public void test1(int raceCount, int carCount){
        Race race = Race.from(raceCount, carCount);

        Assertions.assertThat(race.getRaceCount()).isEqualTo(raceCount);
        Assertions.assertThat(race.getCars().size()).isEqualTo(carCount);
    }

}