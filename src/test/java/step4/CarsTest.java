package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.Data;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 목록 생성")
    @ValueSource(strings = {"bob,test,weif,a","a,bb,ccc","car,move"})
    public void createCar(String names){
        Data data = new Data(names);

        List<Car> carList = new Cars().createdList(data);

        assertThat(carList.size()).isEqualTo(data.spliteName(",").length);

    }

}
