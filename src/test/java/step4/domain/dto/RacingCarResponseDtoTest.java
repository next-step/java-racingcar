package step4.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.driver.Driver;
import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarResponseDtoTest {

    private final int ZERO = 0;
    private final int FIVE = 5;
    private final int TEN = 10;

    private List<Driver> sampleDrivers;

    @BeforeEach
    void setUp() {
        Driver sampleDriver = Driver.from(Name.from("etc", name -> true), Car.getInstance());
        sampleDrivers = new ArrayList<>();
        sampleDrivers.add(sampleDriver);
    }

    @DisplayName("RacingCarResponseDto 의 add() 메서드 동작 검증을 위한 테스트")
    @Test
    void addTest() {
        // given
        RacingCarResponseDto racingCarResponseDto = RacingCarResponseDto.newInstance();

        // when
        racingCarResponseDto.add(sampleDrivers);
        List<Driver> DriversActual = racingCarResponseDto.getRacingRecords();
        int actual = DriversActual.size();
        int expected = sampleDrivers.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }


}