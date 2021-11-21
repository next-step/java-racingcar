package racing.basic.application;

import racing.basic.resolver.InputViewResolver;
import racing.basic.resolver.OutputViewResolver;
import racing.basic.domain.CarRacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarRacingApplication {

    private static final int CAR_COUNT_LOCATION  = 0;
    private static final int LOOP_COUNT_LOCATION = 1;

    private InputViewResolver  inputViewResolver;
    private OutputViewResolver outputViewResolver;

    private CarRacingGame carRacingGame;

    public CarRacingApplication() {
        this.inputViewResolver  = new InputViewResolver();
        this.outputViewResolver = new OutputViewResolver();
    }

    public void startGame() {
        List<String> questions = Arrays.asList(
                 "자동차 대수는 몇 대 인가요?"
                ,"시도할 회수는 몇 회 인가요?"
        );
        List<Integer> answers = inputViewResolver.askQuestions(questions);

        int carCount  = answers.get(CAR_COUNT_LOCATION);
        int loopCount = answers.get(LOOP_COUNT_LOCATION);

        carRacingGame = new CarRacingGame(carCount);

        for (int i = 0; i < loopCount; i++) {
            List<Integer> randomNumbers = randomNumbersByCarCount(carCount);
            List<Integer> displayTrack = carRacingGame.nextRound(randomNumbers);
            outputViewResolver.sendMessage(displayTrack);
        }
    }

    private List<Integer> randomNumbersByCarCount(int carCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < carCount; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
