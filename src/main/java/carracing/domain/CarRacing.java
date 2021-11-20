package carracing.domain;

import carracing.exception.CarNameFormatException;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

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

    public static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";


    public RaceResult racingStart(InputView inputView) throws CarNameFormatException {

        RaceResult raceResult = new RaceResult();
        ResultView resultView = new ResultView();
        List<Car> carList = new ArrayList<>();

        createCarNameList(inputView, carList);

        Cars cars = new Cars(carList);
        for (int i = 0; i < inputView.getTryCount(); i++) {
            racing(cars, inputView);                 /* 시도 횟수 만큼 주행 */
            resultView.printRacing(cars);            /* 시도 횟수 만큼 출력 */
            raceResult.roundCount++;
        }

        raceResult.findMaximumDistance(cars);
        Winners winners = cars.getWinner(raceResult);
        resultView.printWinner(winners);

        return raceResult;
    }

    private void createCarNameList(InputView inputView, List<Car> carList) throws CarNameFormatException {
        for (int i = 0; i < inputView.getCarCount(); i++) {
            carList.add(new Car(inputView.getCarStringList().get(i)));
        }
    }

    public void racing(Cars carList, InputView inputView) {
        for (int i = 0; i < inputView.getCarCount(); i++) {
            carList.get(i).driving();
        }
    }

}
