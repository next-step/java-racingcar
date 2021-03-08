package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputViewTest {

    private InputView inputView;

    @BeforeAll
    void init() {
        inputView = new InputView();
    }

    @DisplayName("자동차 댓수 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5"})
    void amountOfCarTest(String number) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(number.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteArrayInputStream);

        Assertions.assertEquals(inputView.getAmountOfCar() , Integer.parseInt(number));
    }

    @DisplayName("레이싱 시도 횟수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5"})
    void countOfCarRacingTest(String number) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(number.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteArrayInputStream);

        Assertions.assertEquals(inputView.getCountOfCar() , Integer.parseInt(number));
    }

}