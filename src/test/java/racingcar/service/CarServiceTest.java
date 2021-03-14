package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarServiceTest {

    private CarRepository carRepository;
    private CarService carService;

    @BeforeEach
    public void setUp() {
        this.carRepository = new CarRepository();
        this.carService = new CarService(this.carRepository);
    }


    @Test
    @DisplayName("자동차 추가 로직 검증 테스트")
    public void addCar() throws Exception {
        //given
        String name = "pobi";

        //when
        carService.addCar(name);
        int currentSize = carService.findCars().size();

        //then
        assertEquals(1, currentSize, "추가한 만큼 크기가 증가해야 한다.");
    }

    @Test
    @DisplayName("모든 자동차 찾는 로직 검증 테스트")
    public void findCars() throws Exception {
        //given
        carRepository.save(new Car("onr"));
        carRepository.save(new Car("two"));
        carRepository.save(new Car("three"));

        //when
        List<Car> cars = carService.findCars();

        //then
        assertEquals(3, cars.size(), "찾은 자동차의 수가 추가한 자동차의 수와 같아야 한다.");
    }

    @Test
    @DisplayName("모든 자동차의 이동범위 찾는 로직 검증 테스트")
    public void findMovementRangeOfCars() throws Exception {
        //given
        Car onr = new Car("onr");
        onr.move(5);
        Car two = new Car("two");
        two.move(1);
        carRepository.save(onr);
        carRepository.save(two);

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
        String name = "pobi";
        Car car = new Car(name);
        carRepository.save(car);

        //when
        Car foundCar = carService.findCar(name);
        String foundName = foundCar.getName();

        //then
        assertEquals(name, foundName, "추가한 자동차와 찾은 자동차의 이름이 같아야 한다.");
    }
}