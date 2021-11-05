package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameHistoryTest {

    private GameHistory gameHistory;

    @BeforeEach
    void setUp() {
        gameHistory = new GameHistory();
    }

    @DisplayName("getHistory(time) 메서드를 통해 history를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0"}, delimiter = ':')
    void saveAndGetHistoryTest(Integer time, String historyStr) {
        List<Position> history = stringParser(historyStr);
        gameHistory.save(time, history);

        List<Position> returnHistory = gameHistory.getHistory(time);
        assertThat(history).isNotSameAs(returnHistory);
        assertThat(history).isEqualTo(returnHistory);
    }

    @DisplayName("getHistory(time) 메서드를 통해 history 가져온 history는 입력 된 List<>와는 다른 List<>이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0"}, delimiter = ':')
    void saveAndGetHistoryNotSameTest(Integer time, String historyStr) {
        List<Position> history = stringParser(historyStr);
        gameHistory.save(time, history);

        List<Position> returnHistory = gameHistory.getHistory(time);
        assertThat(history).isNotSameAs(returnHistory);
    }

    @DisplayName("getHistory(time) 없는 time을 가져오려고하면 IllegalException이 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0"}, delimiter = ':')
    void getNoSearchTest(Integer time, String historyStr) {
        List<Position> history = stringParser(historyStr);
        gameHistory.save(time, history);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            gameHistory.getHistory(2);
        });
    }

    private List<Position> stringParser(String str) {
        String[] split = str.split(",");
        return Arrays.stream(split)
                .map(item -> Position.create(Integer.parseInt(item)))
                .collect(Collectors.toList());
    }

}