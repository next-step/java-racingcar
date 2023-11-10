package racing.domain;


import racing.ui.InputView;

import java.util.Collection;
import java.util.Collections;

public class Racing {

    private final String CANNOT_BE_NEGATIVE_NUMBERS = "음수 입력 불가능합니다.";

    private int carCount = 0;

    private int tryCount = 0;

    private Cars carList = new Cars();

    public Racing(){
        this.carCount = InputView.getCarCount();
        this.tryCount = InputView.getTryCount();
        carList.makeCarList(InputView.getCarName());
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
