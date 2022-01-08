package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    @DisplayName("winner 객체가 잘 담기는지 확인한다")
    void addWinner() {
        //given
        Winner winner = new Winner();
        String winnerName = "AAA";

        //when
        winner.addWinnerCar(winnerName);

        //then
        Assertions.assertThat(new Winner()).isNotEqualTo(winner);
    }

    @Test
    @DisplayName("maxDistance 를 지닌 자동차는 winner 로 선정된다")
    void findWinnerCar() {
        //given
        Winner winner = new Winner();
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");
        int maxDistance = 1;
        car1.move(() -> true);

        //when
        winner.findWinnerCar(car1, maxDistance);
        winner.findWinnerCar(car2, maxDistance);

        //then
        Assertions.assertThat(new Winner()).isNotEqualTo(winner);
        Assertions.assertThat(winner.getWinnerCar().size()).isEqualTo(1);
    }
}