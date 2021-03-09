package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarServiceTest {


    @Test
    @DisplayName("자동차 추가 로직 검증 테스트")
    public void addCar() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        Car car = new Car();
        String name = "seongbeen";
        car.setName(name);

        //when
        carService.addCar(car);
        int currentSize = carService.findCars().size();
        Car foundCar = carService.findCar(name);

        //then
        assertEquals(1, currentSize, "추가한 만큼 크기가 증가해야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 꺼낸 자동차가 같아야 한다.");
    }
}