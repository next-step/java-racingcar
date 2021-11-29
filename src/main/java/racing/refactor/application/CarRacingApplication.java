package racing.refactor.application;

import racing.refactor.domain.CarRacingGame;
import racing.refactor.domain.MovingStrategy;
import racing.refactor.domain.RandomMovingStrategy;
import racing.refactor.dto.RequestGameCreation;
import racing.refactor.dto.ResponseCar;
import racing.refactor.view.InputViewResolver;
import racing.refactor.view.OutputViewResolver;

import java.util.Arrays;
import java.util.List;

import static racing.refactor.domain.CarBuilder.toCarInformation;

public class CarRacingApplication {

    private static final int ZERO = 0;

    private final InputViewResolver inputViewResolver;
    private final OutputViewResolver outputViewResolver;

    public CarRacingApplication() {
        this.inputViewResolver  = new InputViewResolver();
        this.outputViewResolver = new OutputViewResolver();
    }

    public void startGame() {
        List<String> questions = Arrays.asList(
                 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
                ,"시도할 회수는 몇 회 인가요?"
        );
        RequestGameCreation gameCreationRequest = inputViewResolver.askQuestions(questions);

        List<String> carNames = gameCreationRequest.getCarNames();
        CarRacingGame carRacingGame = new CarRacingGame(CarRacingGame.instanceOfCarNames(carNames));
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        for (int i=ZERO; i < gameCreationRequest.getLoopCount(); i++) {
            carRacingGame.moveCars(randomMovingStrategy);
            List<ResponseCar> displayTrack = toCarInformation(carRacingGame.getCars());
            outputViewResolver.displayTracks(displayTrack);
        }

        List<ResponseCar> winners = toCarInformation(carRacingGame.getWinners());
        outputViewResolver.displayWinners(winners);
    }
}
