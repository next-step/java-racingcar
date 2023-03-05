package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.provider.CsvSource;
import study.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class CalcJosephTest2 {
    private CalcJoseph calcJoseph;

    @BeforeEach
    public void setUp() {
        calcJoseph = new CalcJoseph();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "3 + 4 * 3 - 2"})
    public void test(String input) {
        calcJoseph.calculateFinal(input);
    }

}
