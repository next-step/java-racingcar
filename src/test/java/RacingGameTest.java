import org.junit.Test;
import racingGame.domain.Car;
import racingGame.domain.RacingGame;
import racingGame.view.InputView;
import racingGame.view.InputViewImpl;
import racingGame.view.OutputView;
import racingGame.view.OutputViewImpl;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    public void 차_이름_구하기() {
        Car car = new Car.Builder().carName("소나타").runMinPoint(0).runMaxPoint(9).build();
        assertThat(car.getCarName()).isEqualTo("소나타");
    }

    @Test
    public void 차_주행() {
        Car car = new Car.Builder().carName("소나타").runMinPoint(0).runMaxPoint(9).build();
        assertThat(car.getRunDistance()).isEqualTo(0);

        car.run(0);
        assertThat(car.getRunDistance()).isEqualTo(1);

        car.run(10);
        assertThat(car.getRunDistance()).isEqualTo(1);
    }

    @Test
    public void 레이싱게임() {
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        String[] carsNames = {"소나타", "K5", "SM6", "말리부"};

        inputView.setInputCarsName(carsNames);
        inputView.setInputRunDistance(4);
        RacingGame racingGame1 = new RacingGame(inputView, outputView);

        racingGame1.gameStart();
    }
}
