package racingCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    RacingCar racingCar;

    Car car;
    @Test
    void makeCarListTest(){
        //given
        String input= "pobi,woni,jun";

        List<Car> carList = racingCar.makeCarList(input);

        assertThat(carList).hasSize(3);
    }

    @Test
    void makeCarNameListErrorTest(){
        //given
        String input= "pobiadd,woni,jun";

        assertThatThrownBy(()->racingCar.makeCarNameList(input))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }


    @Test
    void makeCarNameListTest(){
        //given
        String input= "pobi,woni,jun";

        String[] carNameArr = racingCar.makeCarNameList(input);

        assertThat(carNameArr).hasSize(3);
    }

    @Test
    void getWinnersTest(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",5));
        carList.add(new Car("woni",4));
        carList.add(new Car("jun",5));

        assertThat(racingCar.getWinners(carList,5)).isEqualTo("pobi,jun");
    }

}
