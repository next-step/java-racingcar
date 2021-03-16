package carRacing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void initCarTest(){
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    @DisplayName("move car test - move forward")
    void moveCarTest(int input){
        car.moveByRandomInt(input);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("move car test - hole position")
    void moveCarTest2(int input){
        car.moveByRandomInt(input);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}