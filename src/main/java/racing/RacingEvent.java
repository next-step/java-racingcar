package racing;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;
import racing.util.RandomUtil;
import racing.view.ResultView;

public class RacingEvent {

    private Cars cars;
    private int count;
    private final ResultView resultView = new ResultView();

    public RacingEvent(Cars cars, int tryCont) {
        this.cars = cars;
        this.count = tryCont;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCount() {
        return count;
    }


    public void startEvent(){
        resultView.resultStart();
        for (int round = 0; count > round; round++){
            start();
        }
        finish();
    }

    public void start(){
        cars.getCars().forEach(car -> {
            car.tryMove(RandomUtil.random());
            resultView.resultView(car);
        });
    }

    public void finish(){
        resultView.showWinner(cars.winner().getWinners());
    }
}
