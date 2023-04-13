package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차를 입력한 이름의 수 만큼 생성한다.")
    void createCar() {
        String names = "포비,크롱,뽀로로";
        int attemptCount = 3;
        UserInput userInput = new UserInput(names, attemptCount);
        List<Car> inpurCars = Cars.createCars(userInput.getNamesForCars(),
                userInput.getNumbersOfCar());
        Cars cars = new Cars(inpurCars);

        assertThat(cars.countCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("원하는 순서의 자동차를 가져올 수 있다.")
    void getCar() {
        String names = "포비,크롱,뽀로로";
        int attemptCount = 3;
        UserInput userInput = new UserInput(names, attemptCount);
        List<Car> inpurCars = Cars.createCars(userInput.getNamesForCars(),
                userInput.getNumbersOfCar());
        Cars cars = new Cars(inpurCars);

        Car eachCar = cars.getEachCar(1);
        assertThat(eachCar.getCarName()).isEqualTo("크롱");
    }

    @Test
    @DisplayName("우승자의 이름 리스트를 가지고 온다.")
    void getFarthestDistance() {
        Car ethanCar = new Car("ethan");
        ethanCar.attemptMove(true);
        ethanCar.attemptMove(true);
        ethanCar.attemptMove(true);
        Car rickCar = new Car("rick");
        rickCar.attemptMove(true);
        rickCar.attemptMove(true);

        Cars cars = new Cars(List.of(ethanCar, rickCar));

        String[] winnerNames = cars.getWinnerNames();
        assertThat(winnerNames[0]).isEqualTo("ethan");
    }
}
