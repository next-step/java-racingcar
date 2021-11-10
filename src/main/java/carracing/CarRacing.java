package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private static final int RANDOM_RANGE = 10;     /* 랜덤 숫자 범위 */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_COUNT);
        String carCount = scanner.nextLine();

        System.out.println(QUESTION_TRY_COUNT);
        String tryCount = scanner.nextLine();

        process(carCount, tryCount);
    }

    /**
     * 메인 기능 수행하는 메소드
     */
    public static void process(String carCount, String tryCount) {

        List<Car> carList = new ArrayList<>();          /* 주행할 자동차 목록 */
        InputView inputView = new InputView();          /* 주행 입력 */
        inputView.valid(carCount, tryCount);            /* 입력 검증 */
        ResultView resultView = new ResultView();       /* 출력 클래스 생성 */

        for (int i = 0; i < inputView.getCarCount(); i++) {
            carList.add(new Car());                     /* 자동차 초기화 */
        }

        for (int i = 0; i < inputView.getTryCount(); i++) {
            racing(carList, inputView);                 /* 자동차 주행 */
            resultView.printRacing(carList);            /* 주행 이력 출력 */
        }
    }

    /**
     * 차량 주행 기능 메소드
     */
    public static void racing(List<Car> RACING_CAR, InputView inputView) {
        for (int i = 0; i < inputView.getCarCount(); i++) {
            int randomNum = new Random().nextInt(RANDOM_RANGE);
            RACING_CAR.get(i).driving(randomNum);
        }
    }

}
