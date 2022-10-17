package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.RandomIntegerGenerator;
import com.nextlevel.kky.racing.service.CarCreateService;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarCreateServiceTest {

    @Test
    void carCreateTest() {
        String[] carNames = new String[]{"qwe", "poi"};
        CarCreateService carCreateService = new CarCreateService(new RandomIntegerGenerator());
        List<Car> cars =  carCreateService.create(carNames);

        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream().map(Car::getName)).containsExactly(carNames);
    }

    @Test
    void carCreateFailedTest() {
        CarCreateService carCreateService = new CarCreateService(new RandomIntegerGenerator());

        assertThatThrownBy(() -> carCreateService.create(new String[]{"qwe", "poi1"}))
                .isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("유효하지 않은 이름 입니다!");
    }
}
