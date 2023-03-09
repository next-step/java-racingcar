package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void Name(){
        var car = new Car("jason",0);
        assertThat(car.getName()).isEqualTo("jason");
    }
    @DisplayName("자동차경주 참여자 리스트를 만든다")
    @Test
    void makeCarListTest(){
        //given
        RacingCar racingCar = new RacingCar();
        String input= "pobi,woni,jun";

        List<Car> carList = racingCar.makeCarList(input);

        assertThat(carList).hasSize(3);
    }

    @DisplayName("자동차 이름의 길이가 5자를 넘으면 예외가 발생한다.")
    @Test
    void makeCarListErrorTest(){
        //given
        RacingCar racingCar = new RacingCar();
        String input= "pobiadd,woni,jun";

        assertThatThrownBy(()->racingCar.makeCarList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 이동한다")
    @Test
    void excuteCarRacingTest(){
        //given
        RacingCar racingCar = new RacingCar();
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("pobi",0));
        carList.add(new Car("woni",0));
        carList.add(new Car("jun",0));

        racingCar.excuteCarRacing(carList);
    }
    @DisplayName("자동차 경주 우승자 찾기")
    @Test
    void getWinnersTest(){
        //given
        RacingCar racingCar = new RacingCar();
        List<Car> carList = new ArrayList<>();
        
        carList.add(new Car("pobi",5));
        carList.add(new Car("woni",4));
        carList.add(new Car("jun",5));

        assertThat(racingCar.getWinners(carList)).isEqualTo("pobi,jun");
    }

}