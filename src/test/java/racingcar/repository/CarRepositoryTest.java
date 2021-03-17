package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryTest {

    private List<Car> cars;
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        this.cars = new ArrayList<>();
        this.carRepository = new CarRepository(cars);
    }

    @Test
    @DisplayName("자동차 추가 검증 로직 테스트")
    public void save() throws Exception {
        //given
        String name = "sean";
        Car car = new Car(name);


        //when
        carRepository.save(car);
        int currentSize = carRepository.findAll().size();
        Car foundCar = carRepository.findByName(new Name(name));

        //then
        assertEquals(1, currentSize, "추가한 만큼 크기가 증가해야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 꺼낸 자동차가 같아야 한다.");
    }

    @Test
    @DisplayName("모든 자동차 찾는 로직 검증 테스트")
    public void findAll() throws Exception {
        //given
        carRepository.save(new Car("sean"));
        carRepository.save(new Car("pobi"));
        carRepository.save(new Car("bibi"));

        //when
        List<Car> cars = carRepository.findAll();

        //then
        assertEquals(3, cars.size(), "찾은 자동차의 수가 추가한 자동차의 수와 같아야 한다.");
    }

    @Test
    @DisplayName("최대 이동 범위 값을 통해 우승자 찾는 테스트")
    public void findWinnersByMaxPosition() throws Exception {
        //given
        Position maxPosition = new Position(10);
        Car sean = new Car("sean", 10);
        Car pobi = new Car("pobi", 10);
        Car bibi = new Car("bibi", 9);
        carRepository.save(sean);
        carRepository.save(pobi);
        carRepository.save(bibi);

        //when
        List<Car> winners = carRepository.findWinnersByMaxPosition(maxPosition);

        //then
        assertThat(winners).containsExactly(sean, pobi);
    }

    @Test
    @DisplayName("이름을 통해 자동차 찾는 테스트")
    public void findByName() throws Exception {
        //given
        Car sean = new Car("sean");
        Car pobi = new Car("pobi");
        carRepository.save(sean);
        carRepository.save(pobi);

        //then
        assertThat(carRepository.findByName(new Name("sean"))).isEqualTo(sean);
    }

    @Test
    @DisplayName("최대 이동 범위를 가진 자동차 찾는 테스트")
    public void findMaxPosition() throws Exception {
        //given
        Car sean = new Car("sean", 10);
        Car pobi = new Car("pobi", 8);
        Car bibi = new Car("bibi", 9);
        carRepository.save(sean);
        carRepository.save(pobi);
        carRepository.save(bibi);

        //then
        assertThat(carRepository.findMaxPosition()).isEqualTo(sean.getPosition());
    }


}