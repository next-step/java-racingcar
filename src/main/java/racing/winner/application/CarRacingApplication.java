package racing.winner.application;

import racing.winner.domain.CarRacingGame;
import racing.winner.resolver.CarDto.Request;
import racing.winner.resolver.CarDto.Response;
import racing.winner.resolver.InputViewResolver;
import racing.winner.resolver.OutputViewResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static racing.winner.domain.CarBuilder.toCar;
import static racing.winner.domain.CarBuilder.toCarInformation;

public class CarRacingApplication {

    private static final int ZERO = 0;
    private static final int TEN = 10;

    private InputViewResolver  inputViewResolver;
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

        carRacingGame = new CarRacingGame(toCar(gameCreationRequest));

        for (int i = ZERO; i < gameCreationRequest.getLoopCount(); i++) {
            List<Integer> randomNumbers = randomNumbersByCarCount(gameCreationRequest.getCarCount());
            List<Response.CarInformation> displayTrack = toCarInformation(carRacingGame.nextRound(randomNumbers));
            outputViewResolver.displayTracks(displayTrack);
        }
        List<Response.CarInformation> winners = toCarInformation(carRacingGame.getWinners());
        outputViewResolver.displayWinners(winners);
    }

    private List<Integer> randomNumbersByCarCount(int carCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = ZERO; i < carCount; i++) {
            int randomNumber = random.nextInt(TEN);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
