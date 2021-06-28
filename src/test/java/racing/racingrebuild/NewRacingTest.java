package racing.racingrebuild;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NewRacingTest {

    @DisplayName("쪼개기")
    @Test
    public void splitNameTest(){
        ArrayList<Car> car;
        String name= "강호동가스,유재석";
        NewRacing newRacing = new NewRacing();
        car = newRacing.splitName(name);
        Assertions.assertThat(car.get(0).getCarName()).isEqualTo("강호동가");
    }


    @DisplayName("레이싱 테스트")
    @Test
    public void raceStartTest(){
        String name= "강호동가스,유재석";
        NewRacing newRacing = new NewRacing();
        ArrayList<Car> car = newRacing.raceStart("강호동,유재석,신동엽",10);
        Assertions.assertThat(car.get(0).getCarName()).isEqualTo("강호동");
    }


    @DisplayName("승자 테스트")
    @Test
    public void winnerTest(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("강호동",5));
        cars.add(new Car("유재석",5));
        cars.add(new Car("신동엽",3));

        NewRacing newRacing = new NewRacing();
        List<Car> ca = newRacing.winner(cars);
        Assertions.assertThat(ca.get(0).getCarName()).isEqualTo("강호동");
        Assertions.assertThat(ca.get(1).getCarName()).isEqualTo("유재석");
    }


}
