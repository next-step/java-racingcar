package study.racingcar.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.car.moving.DefaultMovingSuccessStrategy;
import study.racingcar.view.DefaultInputView;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,false"}, delimiter = ',')
    void test_doMoreTry(int count, boolean result) {

        // When
        DefaultGameConfiguration defaultGameConfiguration
                = new DefaultGameConfiguration(new DefaultInputView(), 3, 3
                , DefaultMovingSuccessStrategy.getInstance());

        // Then
        Assertions.assertEquals(defaultGameConfiguration.doMoreTry(count), result);
    }

}