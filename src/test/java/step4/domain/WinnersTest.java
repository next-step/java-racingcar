package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.Winners;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("winners : get single winner string test")
    public void getSingleWinnerStringTest(){
        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(0);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);

        Winners winners = new Winners(2);
        winners.add(car1);
        winners.add(car2);
        winners.add(car3);

        //when
        //then
        assertThat(winners.getWinnerString()).isEqualTo("car3");
    }

    @Test
    @DisplayName("winners : get multiple winner string test")
    public void getMultipleWinnerStringTest(){
        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(4);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);

        Winners winners = new Winners(2);
        winners.add(car1);
        winners.add(car2);
        winners.add(car3);

        //when
        //then
        assertThat(winners.getWinnerString()).isEqualTo("car1,car3");
    }
}
