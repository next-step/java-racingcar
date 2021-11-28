package racing.refactor.application;

import racing.refactor.domain.CarRacingGame;
import racing.refactor.domain.Cars;
import racing.refactor.domain.MovingStrategy;
import racing.refactor.domain.RandomMovingStrategy;
import racing.refactor.view.InputViewResolver;
import racing.refactor.view.OutputViewResolver;
import racing.refactor.view.CarDto.Request;
import racing.refactor.view.CarDto.Response;

import java.util.Arrays;
import java.util.List;

import static racing.refactor.domain.CarBuilder.toCarInformation;

public class CarRacingApplication {

    private static final int ZERO = 0;
    private static final int TEN = 10;

    private InputViewResolver inputViewResolver;
    private OutputViewResolver outputViewResolver;

    private CarRacingGame carRacingGame;

    public CarRacingApplication() {
        this.inputViewResolver  = new InputViewResolver();
        this.outputViewResolver = new OutputViewResolver();
    }

    public void startGame() {
        List<String> questions = Arrays.asList(
                 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
                ,"시도할 회수는 몇 회 인가요?"
        );
        Request.GameCreation gameCreationRequest = inputViewResolver.askQuestions(questions);

        List<String> carNames = gameCreationRequest.getCarNames();
        carRacingGame = new CarRacingGame(Cars.newInstance(carNames));
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        for (int i=ZERO; i < gameCreationRequest.getLoopCount(); i++) {
            List<Response.CarInformation> displayTrack = toCarInformation(carRacingGame.nextRound(randomMovingStrategy));
            outputViewResolver.displayTracks(displayTrack);
        }

        List<Response.CarInformation> winners = toCarInformation(carRacingGame.getWinners());
        outputViewResolver.displayWinners(winners);
    }
}
