package racingcar.car;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarCreatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("전달받은 size의 리스트를 생성하는지 확인")
    void sizeTest(int size){
        assertThat(CarCreator.create(size).size()).isEqualTo(size);
    }

    @Test
    @DisplayName("생성된 리스트의 Car 객체는 다 달라야한다.")
    void createDifferentObjectTest(){
        List<Car> carList = CarCreator.create(2);
        assertThat(carList.get(0)).isNotSameAs(carList.get(1));
    }
}
