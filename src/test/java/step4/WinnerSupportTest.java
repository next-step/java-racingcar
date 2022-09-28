package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WinnerSupportTest {

    private List<Car> cars;

    @BeforeEach
    void setUp(){
        cars = Arrays.asList(
                new Car("suchan"),
                new Car("pob"),
                new Car("jon")
        );
    }

    @Test
    @DisplayName("chooserWinner()로 우승자 문자열을 구한다.")
    void chooseWinner_String(){
        for (Car car : cars) {
            car.moveForward(true);
        };

        String winner = WinnerSupport.chooseWinner(cars);

        Assertions.assertThat(winner).isEqualTo("suchan,pob,jon");
    }
}