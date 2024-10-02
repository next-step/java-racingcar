package step3.game;

import step3.car.CarStrategy;
import step3.car.RacingCar;
import step3.message.ExceptionMessage;
import step3.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame implements GameStrategy {

    private final static int FORWARD_STANDARD = 4; //전진여부를 결정하는 기준
    private final static int miniMumCarNum = 2; //레이싱 시작을 위한 최소 자동차 수
    private final static int miniMumAttemptNum = 1; //레이싱 시작을 위한 최소 시도 횟수

    private final List<CarStrategy> cars = new ArrayList<>();
    private int attemptNum;

    //경기를 준비한다.
    @Override
    public void readyRace(int carNum, int attemptNum) {
        this.attemptNum = attemptNum;
        createCar(carNum);
        checkMinimumAttempt();
    }

    //자동자를 조회한다.
    @Override
    public List<CarStrategy> getRacingCars() {
        return this.cars;
    }

    //시도 횟수를 조회한다.
    @Override
    public int getAttemptNum() {
        return this.attemptNum;
    }

    //자동차들을 각각 전진 1회 시도한다.
    @Override
    public void attemptForwardCar() {
        for (CarStrategy car : cars) {
            if (decideForward()) {
                car.forward();
            }
        }
    }

    //차를 전진시킬지 결정한다.
    public boolean decideForward() {
        return RandomUtil.getRandomValuelessThenTen() >= FORWARD_STANDARD;
    }

    //자동차를 생성한다.
    private void createCar(int carNum) {
        checkMinimumCar(carNum);
        IntStream.range(0, carNum).forEach(i -> cars.add(new RacingCar()));
    }

    //레이싱에 참가하는 자동차가 1대 이하인지 체크
    private void checkMinimumCar(int carNum) {
        if (carNum < miniMumCarNum)
            throw new IllegalArgumentException(ExceptionMessage.MINIMUN_CAR_EXCEPTION.message());
    }

    //레이싱 회수가 1회 미만인지 체크
    private void checkMinimumAttempt() {
        if (this.attemptNum < miniMumAttemptNum)
            throw new IllegalArgumentException(ExceptionMessage.MINIMUN_ATTEMPT_EXCEPTION.message());
    }

}
