package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.StringAddCalculator;
import step3.constants.QuestionConstants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayRacingCarTests {

    @ParameterizedTest
    @ValueSource(strings = {QuestionConstants.HOW_MANY_CARS})
    void racingCar(String questionCars, String questionTimes) {
//        InputStream in = new ByteArrayInputStream(questionCars.getBytes());
//        System.setIn(in);
//
//        Scanner scanner = new Scanner(System.in);
//        assertThatThrownBy(PlayRacingCar::run)
//                .isInstanceOf(RuntimeException.class);
    }
}
