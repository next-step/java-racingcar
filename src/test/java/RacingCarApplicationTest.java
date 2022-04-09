import core.TestObjectGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarApplicationTest {
    private final PrintStream systemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("자동차 이름과 이동횟수를 입력받고 우승자를 출력해야 한다")
    void main() {
        //given
        final String carName = "a";
        final String moveCount = "5";
        String input = String.join("\n", Arrays.asList(carName, moveCount));
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        RacingCarApplication.main(null);

        //then
        assertThat(outputStream.toString()).contains("a가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("자동차 이름과 이동횟수를 입력받고 우승자를 출력해야 한다 2")
    void main2() {
        //given
        final String[] carNames = {"a", "b", "c", "d"};
        final String inputCarNames = String.join(",", carNames);
        final String moveCount = "5";
        String input = String.join("\n", Arrays.asList(inputCarNames, moveCount));
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        RacingCarApplication.main(null);
        List<String> result = parseCarNames(outputStream);

        //then
        result.forEach(carName -> assertThat(carName).isIn(Arrays.asList(carNames)));
    }

    private List<String> parseCarNames(OutputStream outputStream) {
        String[] outputLines = outputStream.toString().split("\n");
        String lastLine = tail(outputLines);
        String[] splitLastLine = lastLine.split(",");
        String lastSplit = tail(splitLastLine);
        Pattern pattern = Pattern.compile("가 최종 우승했습니다\\.$");
        Matcher matcher = pattern.matcher(lastSplit);
        splitLastLine[splitLastLine.length - 1] = matcher.replaceAll("");
        return Arrays.stream(splitLastLine).map(String::trim).collect(Collectors.toList());
    }

    private <T> T tail(T[] array) {
        return array[array.length - 1];
    }
}