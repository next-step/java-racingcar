package racing.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("포지션 값 추출 테스트")
    void getNumberTest() {
        // Given
        final int expectedNumber = 3;
        // When
        Position position = new Position(expectedNumber);
        int actual = position.getNumber();
        // Then
        assertThat(actual).isEqualTo(expectedNumber);
    }


    @ParameterizedTest
    @DisplayName("포지션 움직임 테스트")
    @CsvSource(value = {
            "1, 0",
            "2, 0",
            "4, 1",
            "5, 1"
    }, delimiter = ',')
    void movePosition(int chance, int expectedNumber){
        // Given
        final Position position = new Position();
        // When
        position.movePosition(chance);
        int actual = position.getNumber();
        // Then
        assertThat(actual).isEqualTo(expectedNumber);
    }

    @Test
    @DisplayName("더 큰 포지션 반환 테스트")
    void biggerPositionTest() {
        // Given
        final int biggerNumber = 4;
        final int smallerNumber = 2;
        final Position position = new Position(3);
        final Position biggerPosition = new Position(biggerNumber);
        final Position smallerPosition = new Position(smallerNumber);
        // When
        Position actual1 = position.biggerPosition(biggerPosition);
        Position actual2 = position.biggerPosition(smallerPosition);
        // Then
        assertThat(actual1.getNumber()).isEqualTo(biggerNumber);
        assertThat(actual2.getNumber()).isEqualTo(position.getNumber());
    }
}
