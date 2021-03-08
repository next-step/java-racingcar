package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    private RandomRaceCar car;
    @BeforeEach
    void setUp(){
        car = new RandomRaceCar();
    }
    @ParameterizedTest
    @CsvSource(value = {"4","5"})
    @DisplayName("전진 테스트 - 전진 성공하는 경우, 랜덤값이 4,5라고 가정")
    void 전진테스트(int randomValue){
        car.move(randomValue >= NumberChecker.CONDITION_OF_START);
        assertThat(car.getPosition()).isEqualTo(2);
    }
    @ParameterizedTest
    @CsvSource(value = {"0","1"})
    @DisplayName("전진 테스트 - 전진 실패하는 경우")
    void 전진조건테스트(int randomValue){
        car.move(randomValue >= NumberChecker.CONDITION_OF_START);
        assertThat(car.getPosition()).isEqualTo(1);
    }



}
