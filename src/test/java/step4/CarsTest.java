package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Cars;
import step4.domain.Data;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 목록 생성")
    @ValueSource(strings = {"bob,test,weif,a","a,bb,ccc","car,move"})
    public void createCar(String names){
        Data data = new Data(names);

        Cars cars = new Cars();
        cars.createdList(data);

        assertThat(cars.getCarList().size()).isEqualTo(data.spliteName(",").length);

    }

}
