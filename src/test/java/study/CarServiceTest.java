package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.car.Car;
import study.car.CarServiceImpl;
import study.car.MemoryCarRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarServiceTest {

    MemoryCarRepository memoryCarRepository;
    CarServiceImpl carService;

    @BeforeEach
    public void beforeEach() {
        memoryCarRepository = new MemoryCarRepository();
        carService = new CarServiceImpl(memoryCarRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryCarRepository.clearStore();
    }

    @Test
    @DisplayName("Car 객체를 생성해 repository에 저장한다.")
    void setCarTest() {
        //given
        Car car = new Car();

        //when
        long id = carService.join(car);

        //then
        Car carById = carService.findOneCar(id);
    }

    @Test
    @DisplayName("저장되어있는 모든 Car 객체를 조회한다.")
    void findAllCarTest() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();

        carService.join(car1);
        carService.join(car2);

        //when
        List<Car> allCars = carService.findAllCars();

        //then
        for (Car car : allCars) {
            System.out.println("car id = " + car.getId() + " status = " + car.getStatus());
        }
    }


    @Test
    @DisplayName("차를 움직이는 경우 하이픈이 추가된다.")
    void movingCarTest() {
        //given
        Car car = new Car();
        carService.join(car);

        //when
        carService.movingCar(car);
        carService.movingCar(car);

        //then
        assertThat(car.getStatus()).isEqualTo("--");
    }
}
