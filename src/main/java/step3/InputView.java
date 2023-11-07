package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    protected static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    protected static final String QUESTION_ABOUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    protected static final String QUESTION_ABOUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        int carCount = 0;
        System.out.println(QUESTION_ABOUT_CAR_COUNT);
        try {
            carCount = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carCount;
    }

    public static int inputAttemptCount()  {
        int attemptCount = 0;
        System.out.println(QUESTION_ABOUT_ATTEMPT_COUNT);

        try {
            attemptCount = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return attemptCount;
    }

}
