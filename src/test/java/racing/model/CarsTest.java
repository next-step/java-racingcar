package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"kim", "nick", "june"})
    @DisplayName("레이싱 경주 시작 메서드 호출 성공 (참여자의 이름 정상 출력)")
    void racingGame__ShouldWinAllDrivers(String input) {
        // given
        String[] names = new String[]{"kim", "nick", "june"};
        ResultView resultView = new ResultView();
        
        // when
        Cars cars = new Cars(names);
        List<Car> raceDoneCars = cars.getCurrentSituation();
        resultView.appendCurrentSituation(raceDoneCars);
        String result = resultView.getResult();

        // then
        assertThat(result.contains(input)).isTrue();
    }
}
