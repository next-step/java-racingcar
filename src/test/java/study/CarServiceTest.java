package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.Car;
import study.service.CarService;
import study.repository.CarRepository;
import study.repository.MemoryCarRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarServiceTest {

    CarService carService;
    CarRepository memoryCarRepository;

    @BeforeEach
    public void beforeEach() {
        memoryCarRepository = new MemoryCarRepository();
        carService = new CarService(memoryCarRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryCarRepository.clearStore();
    }

    @Test
    @DisplayName("Car 객체를 생성해 repository에 저장한다.")
    void setCarTest() {
        //given
        Car car = new Car("a", 1);

        //when
        carService.join(car);
        Car savedCar = carService.findOneCar(car);

        //then
        assertThat(savedCar).isEqualTo(car);
    }

    @Test
    @DisplayName("차를 움직이는 경우 position이 증가된다.")
    void movingCarTest() {
        //given
        Car car = new Car("A", 3);
        carService.join(car);
        Car oneCar = carService.findOneCar(car);
        //when
        oneCar.moving(4);
        oneCar.moving(3);
        oneCar.moving(5);

        //then
        assertThat(oneCar.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("position이 같으면 true를 출력한다. ")
    void matchPositionTest() {
        Car car = new Car("a", 3);
        assertThat(car.matchPosition(3)).isTrue();
    }

    @Test
    @DisplayName("테스트하기 힘든 부분을 분리해 테스트 가능하도록 구조화한다. ")
    void carRandomTest() {
        Car car = new Car("a") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        car.moving();
        assertThat(car.matchPosition(1)).isTrue();
    }
}
