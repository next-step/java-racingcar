import domain.Car;
import org.junit.jupiter.api.DisplayName;
import repository.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    Cars cars;
    private String carsName;

    @BeforeEach
    void setUp() {
        carsName = "AAA,BBB,CCC";
        cars = new Cars(carsName);
    }

    @Test
    @DisplayName("Car 값들이 변경되었을 때 잘 반영되는지 확인한다")
    void updateCar() {
        Car newCar = new Car("DDD", "", 0, "start");
        cars.updateCar(0, newCar);
        Assertions.assertThat(cars.getCar(0)).isEqualTo(newCar);
    }

    @Test
    @DisplayName("자동차가 comma 기준으로 Car 객체에 잘 담긴다")
    void splitCarsName() {
        Assertions.assertThat(cars.getCars().size()).isEqualTo(3);
        Assertions.assertThat(cars.getCars().get(0).getName()).isEqualTo("AAA");
    }

    @Test
    @DisplayName("자동차가 이름이 6글자 이상이면 예외가 발생한다")
    void validateNameLengthCheck() {
        for (int i = 0; i < cars.getCars().size(); i++) {
            String name = cars.getCars().get(i).getName();
            cars.validateNameLengthCheck(name);
        }
    }

}