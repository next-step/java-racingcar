package racing.basic.application;

import racing.basic.resolver.InputViewResolver;
import racing.basic.resolver.OutputViewResolver;
import racing.basic.domain.CarRacingGame;

import java.util.Random;

public class CarRacingApplication {

    private static final int CAR_COUNT_LOCATION  = 0;
    private static final int LOOP_COUNT_LOCATION = 1;
    private static final int SLEEP_TIME_MILLISECOND = 100;

    private InputViewResolver  inputViewResolver;
    private OutputViewResolver outputViewResolver;

    private CarRacingGame carRacingGame;

    public CarRacingApplication() {
        this.inputViewResolver  = new InputViewResolver();
        this.outputViewResolver = new OutputViewResolver();
    }

    public void startGame() {
        int[] answers = askQuestions("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
        int carCount  = answers[CAR_COUNT_LOCATION];
        int loopCount = answers[LOOP_COUNT_LOCATION];

        carRacingGame = new CarRacingGame(carCount);

        outputViewResolver.sendMessage("실행 결과");
        for (int i = 0; i < loopCount; i++) {
            int[] randomNumbers = randomNumbersByCarCount(carCount);
            int[] displayTrack = carRacingGame.nextRound(randomNumbers);
            sleep(SLEEP_TIME_MILLISECOND);
            outputViewResolver.sendMessage(displayTrack);
        }
    }

    private int[] askQuestions(String ...questions) {
        int[] answer = new int[questions.length];
        for (int i = 0; i < questions.length; i++) {
            outputViewResolver.sendMessage(questions[i]);
            answer[i] = inputViewResolver.takeInput();
        }
        outputViewResolver.sendMessage("");
        return answer;
    }

    private int[] randomNumbersByCarCount(int carCount) {
        int[] randomNumbers = new int[carCount];
        Random random = new Random();
        for (int i = 0; i < carCount; i++) {
            randomNumbers[i] = random.nextInt(10);
        }
        return randomNumbers;
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
