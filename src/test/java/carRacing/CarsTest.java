package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CarsTest {
    private Cars cars;
    private MovingStrategy movingStrategy;
    private List<String> nameList;

    @BeforeEach
    void create() {
        movingStrategy = new GreaterThanThreeMovingStrategy();
        nameList = Arrays.asList("rubal", "pubao", "ibao");
        int carCount = 3;
        List<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            carList.add(new Car(name, movingStrategy));
        }
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("자동차 목록 생성 확인")
    void 자동차목록_객체_확인() {
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 목록이 선언된 자동차 수만큼 생성되었는지 확인")
    void 자동차목록_거리_반환_확인() {
        assertThat(cars.getState()).hasSize(nameList.size())
                .containsOnly(entry(nameList.get(0), 0), entry(nameList.get(1), 0), entry(nameList.get(2), 0));
    }


    @Test
    @DisplayName("자동차 목록을  생성 목록 거리 반환 확인")
    void 자동차목록_전진_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();
        cars.move(movableRandomGenerator);
        assertThat(cars.getState())
                .containsOnly(entry(nameList.get(0), 1), entry(nameList.get(1), 1), entry(nameList.get(2), 1));
    }

    @Test
    @DisplayName("자동차 경주 완료 후 우승자 목록 반환 확인")
    void 자동차경주_우승자_목록_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();

        cars.move(movableRandomGenerator);
        List<String> result = cars.callWinners();
        assertThat(result).hasSameElementsAs(nameList);
    }
}
