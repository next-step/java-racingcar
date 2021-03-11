package racingcar.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarResponseDtoTest {

    private final int ZERO = 0;
    private final int FIVE = 5;
    private final int TEN = 10;

    private List<Car> firstCars;
    private List<Car> secondCars;

    @BeforeEach
    void setUp() {
        firstCars = IntStream
                .range(ZERO, TEN)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        secondCars = IntStream
                .range(ZERO, FIVE)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    @DisplayName("RacingCarResponseDto 의 add() 메서드 동작 검증을 위한 테스트")
    @Test
    void addTest() {
        // given
        int expected = firstCars.size() + secondCars.size();

        RacingCarResponseDto racingCarResponseDto = RacingCarResponseDto.newInstance();
        racingCarResponseDto.add(firstCars);
        racingCarResponseDto.add(secondCars);

        // when
        int actual = racingCarResponseDto.getRacingRecords().size();

        // then
        assertThat(actual).isEqualTo(expected);

    }


}