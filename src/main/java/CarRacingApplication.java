import car.Car;
import car.randomNumer.impl.FixedNumberByParameter;
import carRacing.Racing;
import carRacing.Winner;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRacingApplication {

    public static void main(String[] args) {

        //basicCarRacing();
        //customCarRacing();
        showWinnerCarRacing();

    }

    //1번 3번 차량만 이기도록 설정
    private static void customCarRacing() {
        //입력부
        InputView inputView = new InputView();

        //1,3번 차량만 앞서가도록 랜덤값 세팅
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new FixedNumberByParameter(9)));
        cars.add(new Car(new FixedNumberByParameter(2)));
        cars.add(new Car(new FixedNumberByParameter(6)));
        cars.add(new Car(new FixedNumberByParameter(1)));

        //레이싱 경주 객체 생성
        Racing racing = new Racing(cars, inputView.moveCount());

        //레이싱 시작
        racing.startRacingCar();

        //레이싱 결과 배열 확인
        List<List<Integer>> resultList = racing.getResultList();

        //출력부
        ResultView resultView = new ResultView();
        //출력값 입력하여 출력
        resultView.showCardRacingResultByResultList(resultList, "@");
    }

    //가장 기본적인 차량경주
    private static void basicCarRacing() {
        //입력부
        InputView inputView = new InputView();

        int carCount = inputView.carCount();
        int moveCount = inputView.moveCount();

        //레이싱 경주 객체 생성
        Racing racing = new Racing(carCount, moveCount);

        //레이싱 시작
        racing.startRacingCar();

        //레이싱 결과 배열 확인
        List<List<Integer>> resultList = racing.getResultList();

        //출력부
        ResultView resultView = new ResultView();
        //출력값 입력하여 출력
        resultView.showCardRacingResultByResultList(resultList, "~");
    }

    //차량명과 우승자를 확인 할 수 있는 차량경주
    private static void showWinnerCarRacing() {
        //입력부
        InputView inputView = new InputView();

        String carList = inputView.carList();
        int moveCount = inputView.moveCount();

        //레이싱 경주 객체 생성
        Racing racing = new Racing(carList, moveCount);

        //레이싱 시작
        racing.startRacingCar();

        //레이싱 결과 배열 확인
        List<Map<String, Integer>> maps = racing.racingResultMap();

        //출력부
        ResultView resultView = new ResultView();

        //출력값 입력하여 출력
        resultView.showCardRacingResultByResultMapList(maps, "~");

        List<Car> cars = racing.Cars();

        List<String> winersString = new Winner().findWinersString(cars);
        resultView.showWinners(winersString);
    }

}
