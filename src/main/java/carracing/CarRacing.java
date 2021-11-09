package carracing;

import java.util.Scanner;

/*
 * CarRacing
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class CarRacing {

    private static InputView inputView;
    private static ResultView resultView;

    private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_COUNT);
        String carCount = scanner.nextLine();

        System.out.println(QUESTION_TRY_COUNT);
        String tryCount = scanner.nextLine();

        inputView = new InputView();
        inputView.valid(carCount, tryCount);
        resultView = new ResultView(inputView.getCarCount());
        process();
    }

    public static void process() {

        for (int i = 0; i < inputView.getTryCount(); i++) {
            resultView.racing();        /* 자동차 주행 */
            resultView.printRacing();   /* 주행 이력 출력 */
        }
    }

}
