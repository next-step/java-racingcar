package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import me.namuhuchutong.step4.controller.UserInputInterceptor;
import me.namuhuchutong.step4.dto.UserInputInformation;
import me.namuhuchutong.step4.dto.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserInputInterceptorTest {

    @DisplayName("자동차 이름은 5자를 넘길 수 없다.")
    @Test
    void car_name_should_be_under_5_character() {
        //given
        String inputString = "abcde,abcdefg";
        int times = 1;
        UserRequest request = new UserRequest(inputString, times);
        UserInputInterceptor interceptor = new UserInputInterceptor();

        //when, then
        assertThatThrownBy(() -> interceptor.handleUserInput(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름들의 수와 자동차의 수는 동일하다.")
    @ParameterizedTest(name = "given Text: [{0}], expected: [{1}]")
    @MethodSource("givenTextAndNumberOfCars")
    void number_of_cars_and_names_should_be_equal(String givenText, int expected) {
        //given
        UserRequest request = new UserRequest(givenText, 1);
        UserInputInterceptor userInputInterceptor = new UserInputInterceptor();

        //when
        UserInputInformation inputInformation = userInputInterceptor.handleUserInput(request);

        //then
        assertThat(inputInformation.getNumberOfCars()).isEqualTo(expected);
    }

    private static Stream<Arguments> givenTextAndNumberOfCars() {
        return Stream.of(
                Arguments.arguments("a", 1),
                Arguments.arguments("a,b", 2),
                Arguments.arguments("a,b,c", 3),
                Arguments.arguments("a,b,c,d", 4)
        );
    }
}
