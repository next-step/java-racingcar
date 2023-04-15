package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = CarFactory.getInstance();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:1", "4:4", "7:7"}, delimiter = ':')
    @DisplayName("입력값 만큼 RacingCar 가 담겨있는 List 를 생성하는지에 대한 테스트 ")
    void createCar(int input, int excepted) {
        List<RacingCar> racingCarList = carFactory.createCar(input);
        assertThat(racingCarList.size()).isEqualTo(excepted);
    }
}