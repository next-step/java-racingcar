package racing.basic.application;

import racing.basic.resolver.InputViewResolver;
import racing.basic.resolver.OutputViewResolver;
import racing.basic.domain.CarRacingGame;

import java.util.Random;

public class CarRacingApplication {

    private static final int CAR_COUNT_LOCATION  = 0;
    private static final int LOOP_COUNT_LOCATION = 1;
    private int[] track;

    private InputViewResolver  inputViewResolver;
    private OutputViewResolver outputViewResolver;

    private CarRacingGame carRacingGame;

    public CarRacingApplication(InputViewResolver inputViewResolver) {
        this.inputViewResolver  = inputViewResolver;
        this.outputViewResolver = new OutputViewResolver();
        Random random = new Random();
        this.carRacingGame = new CarRacingGame(random);
    }

    public void startGame() {
        int[] answers = askQuestions("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
        int carCount  = answers[CAR_COUNT_LOCATION];
        int loopCount = answers[LOOP_COUNT_LOCATION];

        initializeTrack(carCount);

        for (int i = 0; i < loopCount; i++) {
            carRacingGame.nextRound(track);
            sleep(500);
            outputViewResolver.sendMessage(track);
        }
    }

    private int[] askQuestions(String ...questions) {
        int[] answer = new int[questions.length];
        for (int i = 0; i < questions.length; i++) {
            outputViewResolver.sendMessage(questions[i]);
            answer[i] = inputViewResolver.takeInput();
        }
        return answer;
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initializeTrack(int carCount) {
        this.track = new int[carCount];
    }
}
