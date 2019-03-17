package racing.application;

import racing.view.RacingCarsDto;
import racing.view.RacingGameRequestView;
import racing.view.RacingGameResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Condition condition;
    private int time;
    private List<Car> cars = new ArrayList();
    private List<RacingCarsDto> history = new ArrayList();

    public void addHistory(List<Car> cars) {
        history.add(RacingCarsDto.toRacingCarsDto(cars));
    }

    public RacingGame(RacingGameRequestView view, Condition condition) {
        for (int i = 0; i < view.getCarCount(); i++) {
            cars.add(new Car(view.getCarName(i)));
        }

        this.time = view.getGameCount();
        this.condition = condition;
        addHistory(cars);
    }

    public RacingGameResultView start() {
        for (int i = 0; i < time; i++) {
            carsMoveIfConditionMeet();
            addHistory(cars);
        }

        String winners = RacingGameResult.getWinners(cars);
        return RacingGameResultView.toView(winners, history);
    }

    private void carsMoveIfConditionMeet() {
        cars.stream().forEach(this::play);
    }

    private void play(Car car) {
        if (condition.meet()) {
            car.move();
        }
    }
}


