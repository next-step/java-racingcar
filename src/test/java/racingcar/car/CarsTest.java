package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.moverule.RandomMoveRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    Cars cars;

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("전달받은 size의 리스트를 생성하는지 확인")
    void sizeTest(int size){
        cars = new Cars(new RandomMoveRule(), size);
        assertThat(cars.getCarList().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("생성된 리스트의 Car 객체는 다 달라야한다.")
    void createDifferentObjectTest(){
        cars = new Cars(new RandomMoveRule(), 2);
        assertThat(cars.getCarList().get(0)).isNotSameAs(cars.getCarList().get(1));
    }
}