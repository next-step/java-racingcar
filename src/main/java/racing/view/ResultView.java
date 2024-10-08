package racing.view;

import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.result.ResultRacing;
import racing.domain.result.ResultRacings;

public class ResultView implements ResultHandler {

    public void racingPrint(ResultRacings resultRacings, int cycle) {
        int round = 0;
        while(cycle >0 ){
            ResultRacing racing = resultRacings.getResultsRacings().get(round);
            for (Car car : racing.getCars().getItems()) {
                System.out.print(car.getName() + ":");
                movePrint(car);
            }
            round ++;
            cycle --;
            endCycle();
        }
    }

    private void movePrint(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void endCycle() {
        System.out.println();
    }

    @Override
    public void winnerPrint(Cars winner) {
        System.out.println("우승자 발표!");
        for (Car car : winner.getItems()) {
            System.out.println(car.getName());
        }
    }
}
