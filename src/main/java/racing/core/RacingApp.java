package racing.core;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Mover mover = new Mover();

    public RacingApp() {
    }

    public void start(){
        ClientInput racingDto = inputView.getClientInput();
        List<Car> carList = makeCarList(racingDto.getCarCount());
        for(int i = 0; i < racingDto.getTryCount(); i++){
            print(carList, i);
            moveCars(carList);
        }
    }

    private void print(List<Car> carList, int i) {
        if(i == 0) {
            resultView.printStartText();
        }
        resultView.printCarList(carList);
    }

    private List<Car> makeCarList(int size) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            carList.add(new Car());
        }
        return carList;
    }

    private void moveCars(List<Car> carList){
        carList.forEach(mover::move);
    }
}
