package racing.domain;

import java.util.List;

public class Racing {

    private final String CANNOT_BE_NEGATIVE_NUMBERS = "음수 입력 불가능합니다.";

    private int carCount = 0;

    private int tryCount = 0;

    private Cars carList = new Cars();

    public Racing(List<String> carNames, int tryCount){
//        this.carCount = InputView.getCarCount();
        this.tryCount = tryCount;
        carList.makeCarList(carNames);
    }

    public Cars racingStart(MoveStrategy moveStrategy){
        validation(carCount, tryCount);
        carList.move(moveStrategy);
        return carList;
    }

    private void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount < 0){
            throw new RuntimeException(CANNOT_BE_NEGATIVE_NUMBERS);
        }
    }

    public String findWinner(){
        return carList.findWinner();
    }

    public Cars getCars(){
        return carList;
    }
}
