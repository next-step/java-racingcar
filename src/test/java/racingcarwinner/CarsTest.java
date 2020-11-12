package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체가 제대로 생성되는가?")
    public void createCarTest(){
        String strings = "포비,코난,베니";

        Cars.createCar(strings);
        assertThat(Cars.getCar(0).getName()).isEqualTo("포비");
        assertThat(Cars.getCar(1).getName()).isEqualTo("코난");
        assertThat(Cars.getCar(2).getName()).isEqualTo("베니");
    }

}
