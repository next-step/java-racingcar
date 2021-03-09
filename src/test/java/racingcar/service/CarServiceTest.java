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

    @Test
    @DisplayName("모든 자동차 찾는 로직 검증 테스트")
    public void findCars() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        carRepository.save(new Car());
        carRepository.save(new Car());
        carRepository.save(new Car());
        CarService carService = new CarService(carRepository);

        //when
        List<Car> cars = carService.findCars();

        //then
        assertEquals(3, cars.size(), "찾은 자동차의 수가 추가한 자동차의 수와 같아야 한다.");
    }

    @Test
    @DisplayName("모든 자동차의 이동범위 찾는 로직 검증 테스트")
    public void findMovementRangeOfCars() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        Car firstCar = new Car();
        firstCar.move(5);
        Car secondCar = new Car();
        secondCar.move(1);
        carRepository.save(firstCar);
        carRepository.save(secondCar);
        CarService carService = new CarService(carRepository);

        //when
        List<Integer> movementRangeOfCars = carService.findMovementRangeOfCars();

        //then
        assertEquals(1, movementRangeOfCars.get(0), "move()에 4이상의 값이 들어갔다면 이동범위가 1 증가해야 한다.");
        assertEquals(0, movementRangeOfCars.get(1), "move()에 4미만의 값이 들어갔다면 이동범위가 증가하지 않아야 한다.");
        assertEquals(2, movementRangeOfCars.size(), "찾은 이동범위의 수가 추가한 자동차의 수와 같아야 한다.");
    }

    @Test
    @DisplayName("자동차의 이름으로 자동차 찾는 로직 검증 테스트")
    public void findByName() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        Car car = new Car();
        String name = "seongbeen";
        car.setName(name);
        carRepository.save(car);
        CarService carService = new CarService(carRepository);

        //when
        Car foundCar = carService.findCar(name);
        String foundName = foundCar.getName();

        //then
        assertEquals(name, foundName, "추가한 자동차와 찾은 자동차의 이름이 같아야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 찾은 자동차가 같아야 한다.");
    }
}