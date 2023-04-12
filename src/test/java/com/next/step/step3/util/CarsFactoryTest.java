package com.next.step.step3.util;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsFactoryTest {

    @ParameterizedTest(name = "입력에 따라 자동차들을 생성하는지 테스트")
    @MethodSource("provideCreateCarsInputDto")
    void createCars_입력받은_자동차_대수만큼_생성하는지_테스트(InputDto inputDto, int expected) {
        List<Car> cars = CarsFactory.createCars(inputDto);
        assertThat(cars.size()).isEqualTo(expected);
    }

    static Stream<Arguments> provideCreateCarsInputDto() {
        return Stream.of(
                Arguments.of(new InputDto(List.of("a", "b"), 2), 2),
                Arguments.of(new InputDto(List.of("a", "b", "c"), 3), 3),
                Arguments.of(new InputDto(List.of("a", "b", "c", "d"), 4), 4)
        );
    }
}
