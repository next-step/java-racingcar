package step4.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racing.AdvanceprobabilitySixtyPercentReferee;
import step4.racing.Car;
import step4.racing.Cars;
import step4.racing.Winners;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName(" 0 ~ 9 까지 랜덤 값 테스트")
    void randomTest() throws Exception {
        // given
        AdvanceprobabilitySixtyPercentReferee referee  = new AdvanceprobabilitySixtyPercentReferee();

        // when
        boolean goOrNot = referee.judgeToMove();

        // then 이렇게 테스트하는게 무슨 의미가 있을까? 더 좋은 방법이 없을까?
        assertThat(goOrNot).isIn(true,false);
    }

    @Test
    @DisplayName("두개의 차 비교 테스트")
    public void compareCars() throws Exception {
        // given
        Car 포비 = Car.defaultOf("포비", 5);
        Car 브레이보 = Car.defaultOf("브레이보", 6);
        // when
        Car winner = 포비.winnerIs(브레이보);
        // then
        assertThat(winner).isEqualTo(브레이보);
    }

    @Test
    @DisplayName("우승자 뽑기 테스트")
    void vote_winner() {
        // given
        AdvanceprobabilitySixtyPercentReferee referee  = new AdvanceprobabilitySixtyPercentReferee();
        List<Car> carList = List.of(Car.defaultOf("포비",5) ,Car.defaultOf("브레이보",6),  Car.defaultOf("와우",6), Car.defaultOf("디기딩",2));
        Cars cars = Cars.defaultOf(carList);

        // when
        Winners winner = cars.voteWinner();

        // then
        // 일급 컬렉션은 어떤 방식으로 테스트할 수 있을까요? 리뷰어님?
        assertThat(winner.contains(Car.defaultOf("브레이보",6)));

    }
}
