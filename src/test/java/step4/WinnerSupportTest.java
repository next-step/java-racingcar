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
        CarName firstCarName = new CarName("suchan");
        CarName secondCarName = new CarName("pob");
        CarName thirdCarName = new CarName("jon");

        cars = Arrays.asList(
                new Car(firstCarName),
                new Car(secondCarName),
                new Car(thirdCarName)
        );
    }

    @Test
    @DisplayName("chooserWinner()로 우승자 문자열을 구한다.")
    void chooseWinner_String(){
        for (Car car : cars) {
            car.moveForward(4);
        };

        String winner = WinnerSupport.chooseWinner(cars);

        Assertions.assertThat(winner).isEqualTo("suchan,pob,jon");
    }
}