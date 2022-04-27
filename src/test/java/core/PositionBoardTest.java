package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionBoardTest {

    @Test
    @DisplayName("Cars 의 id 를 key 로 갖는 PositionBoard 가 생성된다")
    void create() {
        //given
        Cars cars = TestObjectGenerator.generateCars(3);
        Map<PositionTableKey, List<Integer>> expectedTable = TestObjectGenerator.generateInitialPositionTable(cars);

        //when
        PositionBoard result = PositionBoard.create(cars);

        //then
        assertThat(result.getPositionTable()).isEqualTo(expectedTable);
    }

    @Test
    @DisplayName("Cars 의 position 이 positionTable 에 추가돼야 한다")
    void recordPosition() {
        //given
        int position = 3;
        Cars cars = TestObjectGenerator.generateCarsAtPosition(3, 3);
        PositionBoard positionBoard = PositionBoard.create(cars);
        Map<PositionTableKey, List<Integer>> expectedTable = TestObjectGenerator.generateInitialPositionTable(cars);
        for (Car car : cars.getCars()) {
            expectedTable.get(PositionTableKey.of(car)).add(position);
        }

        //when
        Map<PositionTableKey, List<Integer>> result = positionBoard.recordPosition(cars);

        //then
        assertThat(result).isEqualTo(expectedTable);
    }
}