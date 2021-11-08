package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {


    @DisplayName("Game 생성 시에 GameInformation에 Names나 time 은 null이면 안된다.")
    @Test
    void ofTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(GameInformation.create(null, 10), () -> true);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(GameInformation.create("kay,may", null), () -> true);
        });
    }

    @DisplayName("매번 움직이는 정상 케이스 동작 테스트")
    @Test
    void moveAlwaysTest() {
        String namesStr = "miz,ki,bi";
        Integer time = 3;
        Game game = Game.of(GameInformation.create(namesStr, time), () -> true);

        game.start();

        String positionOne = "1,1,1";
        String positionTwo = "2,2,2";
        String positionThree = "3,3,3";
        Cars oneStep = createCars(namesStr, positionOne);
        Cars twoStep = createCars(namesStr, positionTwo);
        Cars threeStep = createCars(namesStr, positionThree);

        GameHistory gameHistory = game.getGameHistory();
        assertThat(gameHistory.getHistory(0)).isEqualTo(oneStep);
        assertThat(gameHistory.getHistory(1)).isEqualTo(twoStep);
        assertThat(gameHistory.getHistory(2)).isEqualTo(threeStep);
        assertThat(gameHistory.getWinners().toString()).isEqualTo(namesStr);
    }

    private Cars createCars(String nameStr, String positionStr) {
        MoveStrategy moveStrategy = () -> true;
        Names names = new Names();
        names.addNames(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.create(moveStrategy, namesList.get(i), Position.create(Integer.parseInt(positions[i]))));
        }

        return Cars.create(moveStrategy, carList);
    }


}