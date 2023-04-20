package domain;

import static domain.Cars.createCars;
import static org.assertj.core.api.Assertions.assertThat;
import static view.ResultView.WINNER_DELIMITER;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차를 입력한 이름의 수 만큼 생성한다.")
    void createCar() {
        String names = "포비,크롱,뽀로로";
        int attemptCount = 3;
        UserInput userInput = new UserInput(names, attemptCount);
        Cars cars =createCars(userInput.getNamesForCars());

        assertThat(cars.countCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("원하는 순서의 자동차를 가져올 수 있다.")
    void getCar() {
        String names = "포비,크롱,뽀로로";
        int attemptCount = 3;
        UserInput userInput = new UserInput(names, attemptCount);
        Cars cars =createCars(userInput.getNamesForCars());

        Car eachCar = cars.getEachCar(1);
        assertThat(eachCar.getCarName()).isEqualTo("크롱");
    }

    @Test
    @DisplayName("제일 멀리 간 차를 가지고 온다.")
    void getCarWithFarthestDistance(){
        Car ethanCar = makeCarWithMoved("ethan",3);
        Car rickCar = makeCarWithMoved("rick",2);

        Cars cars = new Cars(List.of(ethanCar, rickCar));
        List<Car> carList = cars.checkCarWithFarthestDistance();
        Assertions.assertThat(carList).contains(ethanCar);
    }

    private static Car makeCarWithMoved(String name, int movedCount) {
        Car car = new Car(name);
        for (int i = 0; i < movedCount; i++) {
            car.attemptMove(true);
        }
        return car;
    }
}
