package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PowerSupply;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceModelTest {

    @Test
    @DisplayName("carNames 를 이름으로 갖는 Cars 와 moveCount 를 갖는 RaceModel 이 만들어져야 한다")
    void initialize() {
        //given
        List<CarName> carNames = TestObjectGenerator.generateCarNames();
        final int moveCount = 3;

        //when
        RaceModel result = RaceModel.initialize(carNames, moveCount);

        //then
        assertThat(carNames.size()).isEqualTo(result.getCars().getCars().size());
        result.getCars().getCars().forEach(car -> carNames.remove(car.getCarName()));
        assertThat(carNames.size()).isEqualTo(0);
        assertThat(result.getMoveCount()).isEqualTo(moveCount);
    }

    @Test
    @DisplayName("cars 의 모든 Car 가 moveCount 번 움직여야 한다")
    void moveCarsRandomlyMoveCountTimes() {
        //given
        final int moveCount = 3;
        PowerSupply powerSupply = TestObjectGenerator.generateMovablePowerSupply();
        RaceModel raceModel = TestObjectGenerator.generateRaceModel("a", 3, moveCount);

        //when
        raceModel.moveCarsRandomlyMoveCountTimes(powerSupply);

        //then
        raceModel.getCars().getCars().forEach(movedCar -> assertThat(movedCar.getPosition()).isEqualTo(moveCount));
    }
}