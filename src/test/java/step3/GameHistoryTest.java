package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameHistoryTest {

    private GameHistory gameHistory;

    @BeforeEach
    void setUp() {
        gameHistory = new GameHistory();
    }

    @DisplayName("getHistory(time) 메서드를 통해 history를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0"}, delimiter = ':')
    void saveAndGetHistoryTest(Long time, String historyStr) {
        List<Long> history = stringParser(historyStr);
        gameHistory.save(time, history);

        List<Long> returnHistory = gameHistory.getHistory(time);
        assertThat(history).isNotSameAs(returnHistory);
        assertThat(history).isEqualTo(returnHistory);
    }

    @DisplayName("getHistory(time) 메서드를 통해 history 가져온 history는 입력 된 List<>와는 다른 List<>이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0"}, delimiter = ':')
    void saveAndGetHistoryNotSameTest(Long time, String historyStr) {
        List<Long> history = stringParser(historyStr);
        gameHistory.save(time, history);

        List<Long> returnHistory = gameHistory.getHistory(time);
        assertThat(history).isNotSameAs(returnHistory);
    }

    private List<Long> stringParser(String str) {
        String[] split = str.split(",");
        return Arrays.stream(split)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

}