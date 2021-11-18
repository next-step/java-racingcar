package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DrivingTest {
    @Test
    @DisplayName("0부터 9까지 의 랜덤값 한번 생성")
    public void createRandomNumber() {
        assertThat(Driving.createRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName("0이상 3이하는 정지값 0, 4이상 9이하는 이동값 1이 반환된다.")
    public void validDrivingNumber() {
        assertThat(Driving.driving()).isBetween(0, 1);
    }

    @DisplayName("0이상 3이하 인 경우 정지값 인 0이 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void checkStopNumber(int number) {
        int result = Driving.driving(number);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("4이상 9이하 인 경우 이동값 인 1이 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void checkMoveNumber(int number) {
        int result = Driving.driving(number);
        assertThat(result).isEqualTo(1);
    }

}
