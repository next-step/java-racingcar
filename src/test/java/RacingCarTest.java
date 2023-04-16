import domain.RacingCar;
import domain.RacingCarGame;
import domain.RacingCarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("자동차 경주 테스트")
public class RacingCarTest {

    @Test
    @DisplayName("전진하는 값은 오직 0 ~ 9 이내의 랜덤 값만 생성되어야 한다.")
    void generateRandomNumberTest() {
        int numberOfTest = 1000;
        for (int i = 0; i < numberOfTest; i++) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();

            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }

    @Test
    @DisplayName("전진 후에는 자동차의 위치가 1 증가되어야 한다.")
    void carMoveSuccessTest() {
        RacingCar racingCar = new RacingCar();
        int beforePosition = racingCar.getPosition();

        racingCar.moveForward(5);

        int afterPosition = racingCar.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("전진 조건이 4미만일 경우 자동차는 이동하지 않는다.")
    void carMoveFailTest() {
        RacingCar racingCar = new RacingCar();
        int beforePosition = racingCar.getPosition();

        racingCar.moveForward(0);

        int afterPosition = racingCar.getPosition();
        assertThat(afterPosition).isEqualTo(beforePosition);
    }

    @Test
    @DisplayName("우승자를 찾을 수 있다.")
    void getWinnersTest() {
        String[] names = {"apple", "banana", "lemon"};
        RacingCarGame racingCarGame = new RacingCarGame(new RacingCarList(names));
        String findCarName = "apple";

        RacingCarList racingCarList = racingCarGame.getRacingCarList();
        RacingCar racingCar = racingCarList.getCars()
                .stream()
                .filter(car -> car.getName().equals(findCarName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 이름의 자동차를 찾을 수 없습니다."));
        racingCar.moveForward(5);

        List<RacingCar> winners = racingCarGame.getWinners();
        assertThat(winners).containsOnly(racingCar);
    }

    @Test
    @DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
    void validateCarNameTest() {
        String[] carNames = {"apple", "iphone"};

        assertThatThrownBy(() -> InputView.validateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

