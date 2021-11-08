package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private MoveStrategy moveStrategy = () -> true;

    @DisplayName("cars는 생성할때 Names를 받으면 position이 0인 car를 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi"}, delimiter = ':')
    void createTest(String namesStr) {
        Names names = new Names();
        names.addNames(namesStr);

        MoveStrategy moveStrategy = () -> true;

        Cars carsWithDefaultPosition = Cars.createWithDefaultPosition(names);

        List<Car> expectCarList = names.getNames().stream()
                .map(name -> Car.createWithDefaultPosition(name))
                .collect(Collectors.toList());

        Cars expectCars = Cars.create(expectCarList);

        assertThat(carsWithDefaultPosition).isEqualTo(expectCars);
    }


    @DisplayName("move 호출 각 자동차들의 moveOrStop()을 호출 한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:0,1,2:true:1,2,3"}, delimiter = ':')
    void moveTest(String nameStr, String positionStr, boolean move, String expectPositionStr) {
        Cars nowCars = createCars(nameStr, positionStr, move);

        Cars actualCars = nowCars.move(moveStrategy);

        Cars expect = createCars(nameStr, expectPositionStr, move);

        assertThat(actualCars).isEqualTo(expect);
    }

    @DisplayName("print() name : -- 형식으로 프린트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:1,2,3"}, delimiter = ':')
    void printTest(String nameStr, String positionStr) {
        Cars nowCars = createCars(nameStr, positionStr, true);

        List<Car> carList = createCarList(nameStr, positionStr, true);
        String carListString = carList.stream()
                .map(Car::toStringNameAndPosition)
                .collect(Collectors.joining("\n"));
        assertThat(nowCars.toStringCars()).isEqualTo(carListString);
        System.out.println("carListString = " + carListString);
    }

    @DisplayName("위치가 가장 높은 자동차가 winner 가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:1,2,3:bi", "miz,ki,bi:5,5,3:miz,ki"}, delimiter = ':')
    void printTest(String nameStr, String positionStr, String winnerStr) {
        Cars nowCars = createCars(nameStr, positionStr, true);
        Winners winner = nowCars.getWinner();

        assertThat(winner.toString()).isEqualTo(winnerStr);
    }

    private Cars createCars(String nameStr, String positionStr, boolean move) {
        MoveStrategy moveStrategy = () -> move;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = createCarList(nameStr, positionStr, move);

        return Cars.create(carList);
    }

    private List<Car> createCarList(String nameStr, String positionStr, boolean move) {
        MoveStrategy moveStrategy = () -> move;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.create(namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return carList;
    }
}