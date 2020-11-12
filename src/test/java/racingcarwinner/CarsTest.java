package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체가 제대로 생성되는가?")
    public void createCarTest(){
        String[] strings = {"포비","코난","베니"};

        Cars cars = new Cars(strings);
        assertThat(cars.getCar(0).getName()).isEquals("포비");
        assertThat(cars.getCar(1).getName()).isEquals("코난");
        assertThat(cars.getCar(2).getName()).isEquals("베니");
    }

}
