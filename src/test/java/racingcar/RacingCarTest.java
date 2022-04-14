package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcarver2.InputStringValidator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {


    @DisplayName("입력값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-34", ":1\\2345"})
    void enterInputTest(String input) {
        assertThatThrownBy(() -> {
            InputStringValidator.valid(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
