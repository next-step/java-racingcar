package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("cars는 생성할때 Names를 받으면 position이 0인 car를 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi"}, delimiter = ':')
    void createTest(String namesStr) {
        Names names = new Names();
        names.addNames(namesStr);

        MoveStrategy moveStrategy = () -> true;

        Cars carsWithDefaultPosition = Cars.createWithDefaultPosition(moveStrategy, names);

        List<Car> expectCarList = names.getNames().stream()
                .map(name -> Car.createWithDefaultPosition(moveStrategy, name))
                .collect(Collectors.toList());

        Cars expectCars = Cars.create(moveStrategy, expectCarList);

        assertThat(carsWithDefaultPosition).isEqualTo(expectCars);
    }


    @DisplayName("move 호출 각 자동차들의 moveOrStop()을 호출 한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:0,1,2:true:1,2,3"}, delimiter = ':')
    void moveTest(String nameStr, String positionStr, boolean move, String expectPositionStr) {
        Cars nowCars = createCars(nameStr,positionStr,move);

        Cars actualCars = nowCars.move();

        Cars expect = createCars(nameStr, expectPositionStr, move);

        assertThat(actualCars).isEqualTo(expect);
    }

    private Cars createCars(String nameStr, String positionStr, boolean move) {
        MoveStrategy moveStrategy = () -> move;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < positions.length; i++) {
            carList.add(Car.create(moveStrategy, namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return Cars.create(moveStrategy, carList);
    }
}