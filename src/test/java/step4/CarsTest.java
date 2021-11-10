package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.*;
import step4.service.dto.Winners;
import step4.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private MoveStrategy moveStrategy = () -> true;

    @DisplayName("move 호출 각 자동차들의 moveOrStop()을 호출 한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:0,1,2:true:1,2,3"}, delimiter = ':')
    void moveTest(String nameStr, String positionStr, boolean move, String expectPositionStr) {
        Cars nowCars = createCars(nameStr, positionStr, move);

        Cars actualCars = nowCars.move(moveStrategy);

        Cars expect = createCars(nameStr, expectPositionStr, move);

        assertThat(actualCars).isEqualTo(expect);
    }

    private Cars createCars(String nameStr, String positionStr, boolean move) {
        Names names = new Names();
        names.addNames(nameStr);

        List<Car> carList = createCarList(nameStr, positionStr, move);

        return Cars.create(carList);
    }

    private List<Car> createCarList(String nameStr, String positionStr, boolean move) {
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