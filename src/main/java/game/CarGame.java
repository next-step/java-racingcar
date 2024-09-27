package game;

import car.RacingCar;
import message.ExceptionMessage;
import message.Message;
import uiview.InputView;
import uiview.ResultView;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarGame {

    private final static int miniMumCarNum = 1; //레이싱 시작을 위한 최소 자동차 수
    private final static int miniMumAttemptNum = 1; //레이싱 시작을 위한 최소 시도 횟수

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private final List<RacingCar> cars = new ArrayList<>();
    private int attemptNum; //시도할 횟수

    //경기를 준비한다.
    public void readyRace() {
        createCar(inputView.inputCarNum());
        attemptNum = inputView.inputAttemptNum();
        checkMinimumAttempt();
    }

    //자동차를 생성한다.
    public void createCar(int carNum) {
        checkMinimumCar(carNum);
        IntStream.range(0, carNum).forEach(i -> cars.add(new RacingCar()));
    }

    //레이싱을 시작한다.
    public void startRace() {
        System.out.println(Message.RESULT_MESSAGE.message());
        IntStream.range(0, attemptNum).forEach(i -> {
            for (RacingCar car : cars) {
                car.forward(RandomUtil.getRandomValuelessThenTen());
            }
            raceResult();
        });
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private void raceResult() {
        resultView.resultView(cars);
    }

    //레이싱에 참가하는 자동차가 1대 이하인지 체크
    private void checkMinimumCar(int carNum) {
        if (carNum <= miniMumCarNum)
            throw new IllegalArgumentException(ExceptionMessage.MINIMUN_CAR_EXCEPTION.message());
    }

    //레이싱 회수가 1회 미만인지 체크
    private void checkMinimumAttempt() {
        if (attemptNum < miniMumAttemptNum)
            throw new IllegalArgumentException(ExceptionMessage.MINIMUN_ATTEMPT_EXCEPTION.message());
    }

}
