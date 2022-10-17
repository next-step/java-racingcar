package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.dto.CarRaceResultDto;
import com.nextlevel.kky.racing.dto.CarRaceResultDto.*;
import com.nextlevel.kky.racing.service.CarRacingService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingServiceTest {

    @Test
    void carRacingServiceTest() {
        CarRacingService carRacingService = new CarRacingService(() -> 9);
        String[] carNames = new String[]{"kky", "kdy", "skh"};

        CarRaceResultDto expected = new CarRaceResultDto(
                Arrays.asList(
                        new RoundResultDto(
                                Arrays.asList(
                                        new CarPositionDto("kky", 0),
                                        new CarPositionDto("kdy", 0),
                                        new CarPositionDto("skh", 0)
                                )
                        ),
                        new RoundResultDto(
                                Arrays.asList(
                                        new CarPositionDto("kky", 1),
                                        new CarPositionDto("kdy", 1),
                                        new CarPositionDto("skh", 1)
                                )
                        ),
                        new RoundResultDto(
                                Arrays.asList(
                                        new CarPositionDto("kky", 2),
                                        new CarPositionDto("kdy", 2),
                                        new CarPositionDto("skh", 2)
                                )
                        ),
                        new RoundResultDto(
                                Arrays.asList(
                                        new CarPositionDto("kky", 3),
                                        new CarPositionDto("kdy", 3),
                                        new CarPositionDto("skh", 3)
                                )
                        )),
                Arrays.asList(carNames)
        );

        CarRaceResultDto actual = carRacingService.race(carNames, 3);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
