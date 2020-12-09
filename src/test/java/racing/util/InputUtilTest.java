package racing.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputUtilTest {

    private InputUtil inputUtil;
    @BeforeEach
    void setup(){
        inputUtil = new InputUtil();
    }

    @Test
    void splitCarsName(){
        String carsName = "Morris,Daniel,Choi";
        String[] cars = inputUtil.splitCarNames(carsName);
        assertThat(cars.length).isEqualTo(3);
        assertAll(
                () -> assertThat(cars[0]).isEqualTo("Morris"),
                () -> assertThat(cars[1]).isEqualTo("Daniel"),
                () -> assertThat(cars[2]).isEqualTo("Choi")
        );
    }
    @Test
    void validationCarName(){
        String [] carNames = {"ABCDE","ABC","DEF"};
        int successCarNameSize = inputUtil.validationCars(carNames);
        assertThat(successCarNameSize).isEqualTo(3);
    }

    @Test
    void carNameLimitCharacter() {
        String carName = "abcdef";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy( ( ) ->{
                    inputUtil.carNameLimitCharacter(carName);
                }).withMessage("자동차 이름은 5글자를 초과할 수 없습니다.");


    }
}