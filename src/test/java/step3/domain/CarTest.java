package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car mockCar;
    StringBuilder steps;
    StringBuilder expectedSteps;

    @BeforeEach
    void setUp() {
        steps = new StringBuilder();
        steps.append("---");

        expectedSteps = new StringBuilder();

        mockCar = new Car(steps);
    }

    @ParameterizedTest
    @CsvSource({ "0,false", "3,false", "4,true", "7,true", "9,true" })
    @DisplayName("정수 중에 4~9 사이인 경우 true를 반환하고, 아니면 false를 반환하는 케이스")
    void isMovableSuccess(int value, boolean expected) {
        boolean result = mockCar.isMovable(value);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차가 이동한 정도를 출력하는데 성공")
    void getStepsSuccess() {
        expectedSteps.append("---");
        assertThat(mockCar.getSteps()).isEqualToIgnoringCase(expectedSteps);
    }

    @Test
    @DisplayName("자동차가 1번 전진했을 때 기존 상태에서 한 스텝 추가 성공")
    void addStepSuccess() {
        mockCar.addStep();
        expectedSteps.append("----");
        assertThat(mockCar.getSteps()).isEqualToIgnoringCase(expectedSteps);
    }
}
