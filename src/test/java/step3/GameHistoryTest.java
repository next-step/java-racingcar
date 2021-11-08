package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

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
    @CsvSource(value = {"1:0,1,0:miz,ki,bi"}, delimiter = ':')
    void saveAndGetHistoryTest(Integer time, String positionStr, String nameStr) {
        Cars expect = createCars(nameStr, positionStr);
        gameHistory.save(time, expect);

        Cars actual = gameHistory.getHistory(time);
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("getHistory(time) 없는 time을 가져오려고하면 IllegalException이 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0,1,0:miz,ki,bi"}, delimiter = ':')
    void getNoSearchTest(Integer time, String positionStr, String nameStr) {
        Cars expect = createCars(nameStr, positionStr);
        gameHistory.save(time, expect);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            gameHistory.getHistory(2);
        });
    }


    private Cars createCars(String nameStr, String positionStr) {
        MoveStrategy moveStrategy = () -> true;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.create(moveStrategy, namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return Cars.create(moveStrategy, carList);
    }

}