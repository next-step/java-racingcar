package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Random random = new Random();

     @Test
    @DisplayName("각 자동차는 4이상의 숫자가 들어오면 움직인다.")
    void 자동차들_움직임_테스트(){
        int carCnt = 3;
        NumberProvider numberProvider = () -> random.nextInt(6)+4;
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);


        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(movableStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        assertThat(cars.moveAll()).containsExactly(1,1,1);
    }

    @Test
    @DisplayName("각 자동차는 3이하의 숫자가 들어오면 움직이지 않는다.")
    void 자동차들_움직임_테스트2(){
        int carCnt = 3;
        NumberProvider numberProvider = () -> random.nextInt(4);
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(movableStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        assertThat(cars.moveAll()).containsExactly(0, 0, 0);
    }


    @Test
    @DisplayName("자동차 항상 움직임")
    void 자동차들_움직임_테스트3(){
        int carCnt = 3;
        MovableStrategy movableStrategy = new AlwaysMoveStrategy();

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(movableStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        cars.moveAll();
        assertThat(cars.moveAll()).containsExactly(2,2,2);
    }

    @Test
    @DisplayName("자동차 항상 정지")
    void 자동차들_정지_테스트(){
        int carCnt = 3;
        MovableStrategy movableStrategy = new AlwaysStopStrategy();

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car(movableStrategy, "name"+i));
        }

        Cars cars = new Cars(carList);

        cars.moveAll();
        assertThat(cars.moveAll()).containsExactly(0,0,0);
    }
}
