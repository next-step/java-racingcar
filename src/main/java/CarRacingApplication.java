import car.Car;
import car.randomNumer.impl.RandomNumberByParameter;
import carRacing.Racing;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {

        //랜덤으로 설정
        //basicCarRacing();
        
        //1번 3번 차량만 이기도록 설정
        customCarRacing();

    }

    private static void customCarRacing() {
        //입력부
        InputView inputView = new InputView();

        //1,3번 차량만 앞서가도록 랜덤값 세팅
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new RandomNumberByParameter(9)));
        cars.add(new Car(new RandomNumberByParameter(2)));
        cars.add(new Car(new RandomNumberByParameter(6)));
        cars.add(new Car(new RandomNumberByParameter(1)));

        inputView.setMoveCount();

        //레이싱 경주 객체 생성
        Racing racing = new Racing(cars, inputView.getMoveCount());

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

        inputView.setCarCount();
        inputView.setMoveCount();

        //레이싱 경주 객체 생성
        Racing racing = new Racing(inputView.getCarCount(), inputView.getMoveCount());

        //레이싱 시작
        racing.startRacingCar();

        //레이싱 결과 배열 확인
        List<List<Integer>> resultList = racing.getResultList();

        //출력부
        ResultView resultView = new ResultView();
        //출력값 입력하여 출력
        resultView.showCardRacingResultByResultList(resultList, "~");
    }

}
