package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Name;
import step3.domain.Position;
import step3.domain.Winners;
import step3.view.ResultView;

public class ViewTest {

    @Test
    void 결과테스트() {
        ResultView resultView = new ResultView();
        Car abc = new Car(new Name("abc"), new Position(3));
        Car abcd = new Car(new Name("abcd"), new Position(2));
        List<Car> cars = Arrays.asList(abc, abcd);
        List<Car> winners = Winners.findWinners(cars);
        assertThat(resultView.winnerView(winners)).isEqualTo("abc 가 최종 우승했습니다.");

    }
}
