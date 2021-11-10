package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.*;
import step4.domain.GameHistory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameHistoryTest {

    private GameHistory gameHistory;

    @BeforeEach
    void setUp() {
        gameHistory = new GameHistory();
    }

    @DisplayName("getHistory(time) 메서드를 통해 history를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0,1,0:miz,ki,bi"}, delimiter = ':')
    void saveAndGetHistoryTest(Integer time, String positionStr, String nameStr) {
        Cars expect = createCars(nameStr, positionStr);
        gameHistory.save(expect);

        Cars actual = gameHistory.getHistory().get(0);
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("위치가 가장 높은 자동차가 winner 가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:1,2,3:bi", "miz,ki,bi:5,5,3:miz,ki"}, delimiter = ':')
    void printTest(String nameStr, String positionStr, String winnerStr) {
        Cars nowCars = createCars(nameStr, positionStr);
        gameHistory.save(nowCars);
        gameHistory.makeWinner(0);

        Names expect = new Names();
        expect.addNames(winnerStr);
        assertThat(gameHistory.getWinnerNames()).isEqualTo(expect);
    }

    private Cars createCars(String nameStr, String positionStr) {
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.create(namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return Cars.create(carList);
    }

}