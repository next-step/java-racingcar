package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.GameStep;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {

    public final static int nowStep = 1;
    public final static int stepNumber = 3;
    public final static int carNumber = 3;


    public class StubGameService implements GameService<Cars> {
        public final GameStep gameStep = new GameStep(nowStep, stepNumber);
        public final Cars cars = new Cars(carNumber);


        @Override
        public void initGame() {

        }

        @Override
        public void runStep() {

        }

        @Override
        public Boolean isRunning() {
            return gameStep.isRunning();
        }

        @Override
        public Cars getGameInstance() {
            return cars;
        }
    }

    @Test
    void initGame() {
        //given

        //when


        //then

    }

    @Test
    void runStep() {

    }

    @Test
    void isRunning() {
        //given
        GameService<Cars> stubGameService = new StubGameService();

        //when
        Boolean isRunning = stubGameService.isRunning();

        //then
        assertThat(isRunning).isEqualTo(true);
    }

    @Test
    void getGameInstance() {
        //given
        Cars expectCars = new Cars(carNumber);
        GameService<Cars> stubGameService = new StubGameService();

        //when
        Cars resultCars = stubGameService.getGameInstance();

        //then
        for (int i = 0; i < carNumber; i++) {
            assertThat(resultCars.getCars().get(i)).isEqualToComparingFieldByField(expectCars.getCars().get(i));
        }
        assertThat(resultCars).isExactlyInstanceOf(Cars.class);
    }
}
