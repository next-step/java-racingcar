package racinggame.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("Cars 생성자 테스트")
    @Test
    public void carsConstructorTest(){
        String []carNames= {"a","b"};
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();
        Assertions.assertThat(2).isEqualTo(carList.size());

    }

}