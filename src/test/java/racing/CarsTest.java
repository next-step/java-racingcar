package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Random random = new Random();
    MovableStrategy alwaysMoveStrategy;
    MovableStrategy alwaysStopStrategy;


    @BeforeEach
    void before(){
        NumberProvider numberProvider1 = () -> random.nextInt(6)+4;
        alwaysMoveStrategy = new RandomNumMovableStrategy(numberProvider1);

        NumberProvider numberProvider2 = () -> random.nextInt(4);
        alwaysStopStrategy = new RandomNumMovableStrategy(numberProvider2);
    }

     @Test
    @DisplayName("각 자동차는 4이상의 숫자가 들어오면 움직인다.")
    void 자동차들_움직임_테스트(){
        int carCnt = 3;

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(alwaysMoveStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        assertThat(cars.moveAll()).containsExactly(1,1,1);
    }

    @Test
    @DisplayName("각 자동차는 3이하의 숫자가 들어오면 움직이지 않는다.")
    void 자동차들_움직임_테스트2(){
        int carCnt = 3;

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(alwaysStopStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        assertThat(cars.moveAll()).containsExactly(0, 0, 0);
    }


    @Test
    @DisplayName("우승자 확인 테스트")
    void 우승자_테스트(){
        int carCnt = 3;

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(alwaysStopStrategy, "1"));
        carList.add(new Car(alwaysStopStrategy, "2"));
        carList.add(new Car(alwaysMoveStrategy, "3"));

        Cars cars = new Cars(carList);

        cars.moveAll();
        cars.moveAll();

        assertThat(cars.getWinners().size()).isEqualTo(1);
        assertThat(cars.getWinners()).contains("3");
    }

    @Test
    @DisplayName("2명 우승자 확인 테스트")
    void 우승자_2명_테스트(){
        int carCnt = 3;

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(alwaysStopStrategy, "1"));
        carList.add(new Car(alwaysMoveStrategy, "2"));
        carList.add(new Car(alwaysMoveStrategy, "3"));

        Cars cars = new Cars(carList);

        cars.moveAll();
        cars.moveAll();

        assertThat(cars.getWinners().size()).isEqualTo(2);
        assertThat(cars.getWinners()).contains("3", "2");
    }
}
