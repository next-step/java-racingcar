package racingcarNew.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private List<Car> carList = new ArrayList<>();

    @BeforeEach
    void set(){
        carList.add(new Car("pobi",3));
        carList.add(new Car("jason",2));
        carList.add(new Car("byungkyu",1));
    }

    @Test
    void 자동차_목록들이_생성되는지_확인(){
        Cars cars = new Cars(carList, 3);
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차들이_움직인_후_동일한_목록이_있는지_확인(){
        Cars cars = new Cars(carList, 3);
        cars.moveAll();
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차목록에서_우승자가_있는지_확인(){
        Cars cars = new Cars(carList, 3);
        cars.moveAll();
        assertThat(cars.getWinners()).isNotEmpty();
    }

}