package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.*;
import step4.service.Game;
import step4.domain.GameHistory;
import step4.service.dto.CarsDto;
import step4.service.dto.GameHistoryDto;
import step4.service.dto.GameInformation;
import step4.service.dto.Winners;
import step4.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("매번 움직이는 정상 케이스 동작 테스트")
    @Test
    void moveAlwaysTest() {
        String namesStr = "miz,ki,bi";
        Names names = new Names();
        names.addNames(namesStr);
        Winners winners = Winners.create(names);

        Integer time = 3;
        Game game = Game.of(GameInformation.create(namesStr, time), () -> true);

        GameHistoryDto gameHistoryDto = game.start();

        String positionOne = "1,1,1";
        String positionTwo = "2,2,2";
        String positionThree = "3,3,3";
        Cars oneStep = createCars(namesStr, positionOne);
        Cars twoStep = createCars(namesStr, positionTwo);
        Cars threeStep = createCars(namesStr, positionThree);

        assertThat(gameHistoryDto.getHistory().get(1)).isEqualTo(CarsDto.of(oneStep));
        assertThat(gameHistoryDto.getHistory().get(2)).isEqualTo(CarsDto.of(twoStep));
        assertThat(gameHistoryDto.getHistory().get(3)).isEqualTo(CarsDto.of(threeStep));
        assertThat(gameHistoryDto.getWinners()).isEqualTo(winners);
    }

    private Cars createCars(String nameStr, String positionStr) {
        MoveStrategy moveStrategy = () -> true;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.create(namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return Cars.create(carList);
    }


}