package racing_game;

import racing_game.domain.Cars;
import racing_game.util.RandomUtil;
import racing_game.view.ResultView;

public class RacingEvent {

    Cars cars;
    int count;
    int round;
    private ResultView resultView = new ResultView();

    public RacingEvent(Cars cars, int tryCont) {
        this.cars = cars;
        this.count = tryCont;
    }

    public void startEvent(){
        for (int i=0; i < count; i++){
            round++;
            start();
        }
        finish();
    }

    public void start(){
        resultView.resultStart();
        cars.getCars().forEach(car -> {
            car.tryMove(RandomUtil.random());
            resultView.resultView(car);
        });
    }

    public void finish(){
        if(count == round){
            resultView.showWinner(cars.winner());
        }
    }
}
