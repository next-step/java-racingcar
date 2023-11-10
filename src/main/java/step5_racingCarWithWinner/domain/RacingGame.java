package step5_racingCarWithWinner.domain;


import step5_racingCarWithWinner.util.RacingGameUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame{

    private static final int NUMBER_TO_GO_FORWARD = 4;
    private static final int NUMBER_TO_GET_RANDOM_NUMBER = 10;
    private final int gameCount;

    private final List<Car> carList;
    private final Response response = new Response();

    public RacingGame(String[] carNames, int gameCount){
        inputCheck(carNames, gameCount);

        this.gameCount = gameCount;
        this.carList = getCarList(carNames);

    }

    private void inputCheck(String[] carNames, int gameCount) {
        if(carNames.length <= 0){
            throw new IllegalArgumentException("차의 이름을 한 대 이상 입력해야합니다.");
        }

        if(gameCount <= 0){
            throw new IllegalArgumentException("게임 횟수는 1이상의 값을 입력해야합니다.");
        }
    }

    public Response play() {

        entireGame(carList);

        return response;
    }

    private void entireGame(List<Car> carList) {
        for(int i=0; i<gameCount; i++){
            eachGame(carList);
            response.addEachStageInfo(carList.stream().map(Car::toString).toArray(String[]::new));
        }

    }

    private void eachGame(List<Car> carList) {
        carList.forEach(this::eachCarPlaying);
    }

    private void eachCarPlaying(Car car) {
        if(isSatisfiedGoingForward()){
            car.forward();
        }
    }

    private boolean isSatisfiedGoingForward() {
        return RacingGameUtils.getRandomInt(NUMBER_TO_GET_RANDOM_NUMBER) > NUMBER_TO_GO_FORWARD;
    }

    private List<Car> getCarList(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }
}
