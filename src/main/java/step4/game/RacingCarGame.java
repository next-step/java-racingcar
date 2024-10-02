package step4.game;

import step4.car.CarStrategy;
import step4.car.RacingCar;
import step4.message.ExceptionMessage;
import step4.util.RandomUtil;
import step4.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements GameStrategy {

    private final static int FORWARD_STANDARD = 4; //전진여부를 결정하는 기준
    private final static int miniMumCarNum = 2; //레이싱 시작을 위한 최소 자동차 수
    private final static int miniMumAttemptNum = 1; //레이싱 시작을 위한 최소 시도 횟수

    private List<CarStrategy> cars = new ArrayList<>();
    private int attemptNum;
    private int topDistance = 0;

    public RacingCarGame() {
    }

    public RacingCarGame(List<CarStrategy> cars) {
        this.cars = cars;
    }

    //경기를 준비한다.
    @Override
    public void readyRace(String carName, int attemptNum) {
        this.attemptNum = attemptNum;
        createCar(carName);
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
            forward(car);
        }
    }

    //우승자의 이름을 가져온다.
    @Override
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (CarStrategy car : cars) {
            getTopDistanceCarName(car, winners);
        }
        return winners;
    }


    //차를 전진시킬지 결정한다.
    public boolean decideForward() {
        return RandomUtil.getRandomValuelessThenTen() >= FORWARD_STANDARD;
    }

    //차를 전진시킨다.
    private void forward(CarStrategy car) {
        if (decideForward()) {
            car.forward();
        }
    }

    //자동차를 생성한다.
    private void createCar(String carName) {
        String[] carNameArr = StringUtil.deviceComma(carName);
        checkMinimumCar(carNameArr.length);
        for (String name : carNameArr) {
            cars.add(new RacingCar(name));
        }
    }

    //최고거리인 자동차이름을 세팅한다.
    private void getTopDistanceCarName(CarStrategy car, List<String> winners) {
        if (this.topDistance < car.getDistance()) {
            winners.clear();
            this.topDistance = car.getDistance();
            winners.add(car.getCarName());
        } else if (this.topDistance == car.getDistance()) {
            winners.add(car.getCarName());
        }
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