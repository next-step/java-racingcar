package step4_racintCarWithWinner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame{

    private static final int NUMBER_TO_GO_FORWARD = 4;
    private static final int NUMBER_TO_GET_RANDOM_NUMBER = 9;
    private final String[] carNames;
    private final int gameCount;

    public RacingGame(String[] carNames, int gameCount){
        this.carNames = carNames;
        this.gameCount = gameCount;

        inputCheck(carNames, gameCount);
    }

    private void inputCheck(String[] carNames, int gameCount) {
        if(carNames.length <= 0){
            throw new IllegalArgumentException("차의 이름을 한 대 이상 입력해야합니다.");
        }

        if(gameCount <= 0){
            throw new IllegalArgumentException("게임 횟수는 1이상의 값을 입력해야합니다.");
        }
    }

    public void play() {

        List<Car> carList = getCarList();

        for(int i=0; i<gameCount; i++){
            playing(carList);
            new ResultView<Car>().print(carList);
        }
    }

    private void playing(List<Car> carList) {
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

    private List<Car> getCarList() {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }
}
