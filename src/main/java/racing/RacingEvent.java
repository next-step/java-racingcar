package racing;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;
import racing.util.RandomUtil;
import racing.view.ResultView;

public class RacingEvent {

    private Winners winners;
    private Cars cars;
    private int count;
    private ResultView resultView  = new ResultView();

    public RacingEvent(Cars cars, int tryCont) {
        this.cars = cars;
        this.count = tryCont;
        this.winners = new Winners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public Winners getWinners() {
        return winners;
    }

    public int getCount() {
        return count;
    }


    public void startEvent(){
        resultView.printResultStart();
        for (int round = 0; count > round; round++){
            start();
        }
    }

    public void start(){
        cars.getCars().forEach(car -> {
            car.tryMove(RandomUtil.random());
            resultView.resultView(car);
        });
    }


}
