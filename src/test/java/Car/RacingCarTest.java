package Car;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;


class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();

    }

    void setInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    Method getMethod(String methodName, Class ... argumens){
        Method method = null;
        try {
            method = racingCar.getClass().getDeclaredMethod(methodName, argumens);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    Field getField(String fieldName){
        Field field = null;
        try {
            field = racingCar.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ParameterizedTest
    @CsvSource({
            "3 5, 3, 5",
            "1 4, 1, 4"
    })
    void 자동차대수_테스트(String input, int carCountAnswer, int gameCountAnswer) throws IllegalAccessException {
        setInput(input);
        racingCar.gameStart();
        int carCount = ((int)getField("carCount")
                                .get(racingCar));
        assertThat(carCount).isEqualTo(carCountAnswer);

        int gameCount = (int)getField("gameCount")
                                .get(racingCar);
        assertThat(gameCount).isEqualTo(gameCountAnswer);
    }

    @ParameterizedTest
    @CsvSource({
            "0 5, 0보다 큰 값을 입력해주세요.",
            "-1 4, 0보다 큰 값을 입력해주세요.",
            "3 0, 0보다 큰 값을 입력해주세요.",
            "6 -1, 0보다 큰 값을 입력해주세요.",
            "a 1, 숫자 값을 입력해주세요.",
            "1 a, 숫자 값을 입력해주세요."
    })
    void 자동차대수_테스트_예외발생(String input, String errMessage) throws IllegalAccessException {
        setInput(input);
        assertThatThrownBy(() -> racingCar.gameStart())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errMessage);
    }

    @RepeatedTest(5)
    void 랜덤값확인테스트() throws InvocationTargetException, IllegalAccessException {
        int randomNumber = (int)getMethod("getRandomNumber")
                                    .invoke(racingCar);
        assertThat(randomNumber).matches(n -> n>=0 && n <= 9);
    }

    @ParameterizedTest
    @CsvSource({
            "0, false",
            "1, false",
            "9, true",
            "6, true"
    })
    void 움직임여부테스트(int randomNumber, boolean answer){
        boolean isMove = racingCar.isMove(randomNumber);
        assertThat(isMove).isEqualTo(answer);
    }
}