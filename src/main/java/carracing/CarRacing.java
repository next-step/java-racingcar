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

    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private static final int RANDOM_RANGE = 10;     /* 랜덤 주행 조건 범위 0 ~ 9 */


    public static void main(String[] args) throws CarNameFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_NAMES);
        String carNames = scanner.nextLine();

        System.out.println(QUESTION_TRY_COUNT);
        String tryCount = scanner.nextLine();

        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(new InputView(carNames, tryCount));
    }

    public RaceResult racingStart(InputView inputView) throws CarNameFormatException {

        RaceResult raceResult = new RaceResult();

        List<Car> carList = new ArrayList<>();
        ResultView resultView = new ResultView();

        for (int i = 0; i < inputView.getCarCount(); i++) {
            carList.add(new Car(inputView.getCarStringList().get(i)));
        }

        for (int i = 0; i < inputView.getTryCount(); i++) {
            racing(carList, inputView, raceResult);     /* 시도 횟수 만큼 주행 */
            resultView.printRacing(carList);            /* 시도 횟수 만큼 출력 */
            raceResult.roundCount++;
        }

        return raceResult;
    }

    public void racing(List<Car> carList, InputView inputView, RaceResult raceResult) {
        for (int i = 0; i < inputView.getCarCount(); i++) {
            int randomNum = new Random().nextInt(RANDOM_RANGE);
            carList.get(i).driving(randomNum);
            raceResult.totalRaceCount++;
        }
    }

}
