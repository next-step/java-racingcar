package step5.game;

import step5.car.CarStrategy;
import step5.car.RacingCar;
import step5.message.ExceptionMessage;
import step5.util.RandomUtil;
import step5.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame implements GameStrategy {

    private final static int FORWARD_STANDARD = 4; //전진여부를 결정하는 기준
    private final static int miniMumCarNum = 2; //레이싱 시작을 위한 최소 자동차 수
    private final static int miniMumAttemptNum = 1; //레이싱 시작을 위한 최소 시도 횟수

    private final List<List<CarStrategy>> raceSituation = new ArrayList<>();

    private List<CarStrategy> cars = new ArrayList<>();
    private int attemptNum;

    public RacingCarGame() {
    }

    public RacingCarGame(List<CarStrategy> cars) {
        this.cars = cars;
    }

    @Override
    public void startRace() {
        checkRestart();
        for (int i = 0; i < attemptNum; i++) {
            attemptForwardCar();
            raceSituation.add(copyCarStrategy());
        }
    }

    //경기를 준비한다.
    @Override
    public void readyRace(String carName, int attemptNum) {
        this.attemptNum = attemptNum;
        createCar(carName);
        checkMinimumAttempt();
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
    public List<String> winnerRace() {
        checkStart();
        return getTopDistanceCarName(getTopDistance());
    }

    @Override
    public List<List<CarStrategy>> getRaceSituation() {
        return raceSituation;
    }

    //차를 전진시킬지 결정한다.
    public boolean decideForward() {
        return RandomUtil.getRandomValuelessThenTen() >= FORWARD_STANDARD;
    }

    public List<CarStrategy> getCars() {
        return cars;
    }

    public int getAttemptNum() {
        return attemptNum;
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

    //자동차의 최고 거리를 구한다.
    private int getTopDistance() {
        int topDistance = 0;
        for (CarStrategy car : cars) {
            topDistance = Math.max(topDistance, car.getDistance());
        }
        return topDistance;
    }

    //최고거리인 자동차이름을 세팅한다.
    private List<String> getTopDistanceCarName(int topDistance) {
        List<String> winner = new ArrayList<>();
        for (CarStrategy car : cars) {
            if(car.isWinner(topDistance)) {
                winner.add(car.getCarName());
            }
        }
        return winner;
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

    //레이싱 재시작하는지를 체크한다.
    private void checkRestart() {
        if (!this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_ALREADY_START.message());
    }

    //시작을 했는지 안했는지 체크한다.
    protected void checkStart() {
        if (this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_NOT_START.message());
    }

    //CarStrategy 객체를 새로운주소로 copy한다.
    private List<CarStrategy> copyCarStrategy() {
        return this.cars.stream()
                .map(CarStrategy::copy)
                .collect(Collectors.toList());
    }

}
