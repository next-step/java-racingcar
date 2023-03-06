package racingCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    RacingCar racingCar;

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
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void makeCarNameListTest(){
        //given
        String input= "pobi,woni,jun";

        List<String> carNameList = racingCar.makeCarNameList(input);

        assertThat(carNameList).hasSize(3);
    }

    @Test
    void excuteCarRacingTest(){
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",0));
        carList.add(new Car("woni",0));
        carList.add(new Car("jun",0));

        racingCar.excuteCarRacing(carList);
    }
    @Test
    void getWinnersTest(){
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",5));
        carList.add(new Car("woni",4));
        carList.add(new Car("jun",5));

        assertThat(racingCar.getWinners(carList,5)).isEqualTo("pobi,jun");
    }

}