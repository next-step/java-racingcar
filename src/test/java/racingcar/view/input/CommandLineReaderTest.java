package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CommandLineReaderTest {

    @Test
    @DisplayName("음수를 입력한 경우 예외처리를 확인한다")
    void checkNegativeNumber() {
        // given
        CommandLineReader.NumberReader numberReader = new CommandLineReader.NumberReader();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    numberReader.parseInput(-1);
                    // then
                }).withMessageMatching("Invalid input");

    }

    @Test
    @DisplayName("최대값 이상을 입력한 경우 예외처리를 확인한다")
    void checkMaxNumber() {
        // given
        CommandLineReader.NumberReader numberReader = new CommandLineReader.NumberReader();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    numberReader.parseInput(1001);
                    // then
                }).withMessageMatching("Invalid input");

    }

    @Test
    @DisplayName("csv 문자열을 정상적으로 파싱한는지 확인한다")
    void checkCsvString() {
        // given
        CommandLineReader.CsvStringReader csvStringReader = new CommandLineReader.CsvStringReader();
        // when
        List<String> result = csvStringReader.parseInput("blue,red,yellow");
        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo("blue");
        assertThat(result.get(1)).isEqualTo("red");
        assertThat(result.get(2)).isEqualTo("yellow");
    }

    @Test
    @DisplayName("csv 문자열이 null인경우 예외처리를 확인한다")
    void checkCsvStringNull() {
        // given
        CommandLineReader.CsvStringReader csvStringReader = new CommandLineReader.CsvStringReader();
        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    csvStringReader.parseInput(null);
                    // then
                }).withMessageMatching("Invalid input");
    }
}
