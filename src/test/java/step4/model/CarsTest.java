package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차 리스트 정렬하기(포지션 내림차순)")
    @ParameterizedTest
    @CsvSource(value = {"10:car1","5:car2", "3:car3"}, delimiter = ':')
    void arrangeCarTest(String position, String name){

    }
}
