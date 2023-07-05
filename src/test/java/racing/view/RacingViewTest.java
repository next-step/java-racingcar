package racing.view;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingViewTest {
    @Test
    void getAskingCarNameViewTest() {
        RacingView racingView = new RacingView();
        String text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

        assertThat(racingView.getAskingCarNameView()).isEqualTo(text);
    }

    @Test
    void getAskingCountViewTest() {
        RacingView racingView = new RacingView();
        String text = "시도할 회수는 몇회인가요?";

        assertThat(racingView.getAskingCountView()).isEqualTo(text);
    }

    @Test
    void getCarStatusViewTest() {
        //given
        RacingView racingView = new RacingView();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));


        //when, then
        assertThat(racingView.getCarStatusView(cars)).isEqualTo("pobi : -\n" +
                "crong : -\n" +
                "honux : -");
    }

    @Test
    void getWinnersViewTest() {
        //given
        RacingView racingView = new RacingView();

        List<String> winners = List.of("test1", "test2");

        //when, then
        assertThat(racingView.getWinnersView(winners)).isEqualTo("test1, test2가 최종 우승했습니다.");
    }

    @Test
    void getResultTitleViewTest() {
        //given
        RacingView racingView = new RacingView();

        //when, then
        assertThat(racingView.getResultTitleView()).isEqualTo("실행 결과");
    }
}