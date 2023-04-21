package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("winners 클래스 생성시 list 초기화")
    @Test
    void when_CreatingWinnerClass_Expects_Empty() {
        //given, when
        Winners winners = new Winners();

        //then
        assertThat(winners.getWinners()).isEmpty();
    }

    @DisplayName("우승자 한명일 경우 리스트에 담기")
    @Test
    void when_WinnerIsOnlyOne_Expects_ContainsExactlyWinner() {
        //given
        Winners winners = new Winners();
        String carName = "junho";
        Car car1 = new Car(carName);

        //when
        winners.add(car1);

        //then
        assertThat(winners.getWinners())
                .extracting(Car::getCarName)
                .hasSize(1)
                .containsExactly(carName);
    }

    @DisplayName("우승자가 여러명일 경우 리스트에 담기")
    @Test
    void when_WinnerIsMoreThanOne_Expects_ContainsExactlyWinner() {
        //given
        Winners winners = new Winners();
        Car car1 = new Car("junho");
        Car car2 = new Car("java");

        //when
        winners.add(car1);
        winners.add(car2);

        //then
        assertThat(winners.getWinners())
                .extracting(Car::getCarName)
                .hasSize(2)
                .containsExactly(car1.getCarName(), car2.getCarName());
    }

    @DisplayName("winner 객체를 가지고 올때 getter 테스트")
    @Test
    void when_CallingGetterMethod_Expects_GetExactList() {
        // given
        Winners winners = new Winners();
        // when
        List<Car> winnerList = winners.getWinners();

        // then
        assertThat(winnerList)
                .isInstanceOf(ArrayList.class)
                .isEmpty();
    }
}