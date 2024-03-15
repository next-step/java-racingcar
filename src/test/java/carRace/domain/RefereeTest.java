package carRace.domain;

import static org.assertj.core.api.Assertions.*;

import carRace.domain.car.Car;
import carRace.domain.car.MoveDistance;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("심판은 가장 멀리 이동한 자동차의 이름을 찾아야한다.")
    public void Referee_Should_Find_Name_Of_Car_Move_Furthest_Among_Cars() throws Exception{
        //given
        Referee sutReferee = new Referee();
        Car namhyoepCar = new Car("namhyoepCar", new MoveDistance(3));
        Car momoCar = new Car("momoCar", new MoveDistance(4));
        Car nanaCar = new Car("nanaCar", new MoveDistance(5));
        List<Car> cars = Arrays.asList(namhyoepCar, momoCar, nanaCar);

        //when
        List<String> winners = sutReferee.findWinners(cars);

        //then
        assertThat(winners).doesNotContain(namhyoepCar.carName());
        assertThat(winners).doesNotContain(momoCar.carName());
        assertThat(winners).contains(nanaCar.carName());
    }

    @Test
    @DisplayName("심판 가장 높은 점수를 가진 우승자가 2이명 우승자도 2명으로 판단한다.")
    public void Referee_Should_Declare_Multiple_Winners_If_Scores_Equal() throws Exception{
        //given
        Referee sutReferee = new Referee();
        Car namhyoepCar = new Car("namhyoepCar", new MoveDistance(3));
        Car momoCar = new Car("momoCar", new MoveDistance(5));
        Car nanaCar = new Car("nanaCar", new MoveDistance(5));
        List<Car> cars = Arrays.asList(namhyoepCar, momoCar, nanaCar);

        //when
        List<String> winners = sutReferee.findWinners(cars);

        //then
        assertThat(winners).doesNotContain(namhyoepCar.carName());
        assertThat(winners).contains(momoCar.carName());
        assertThat(winners).contains(nanaCar.carName());
    }
}
