package racing_mvc.domain;

import java.util.StringJoiner;

public class Winner {
    private Cars winnerCars;
    private CarPosition maxPosition;
    private static String WINNER_NAMES_DELEMETER = ", ";

    public Winner(Cars allCars){
        if(allCars.empty()){
            throw new IllegalArgumentException("경주 중인 자동차가 없습니다.");
        }
        this.winnerCars = new Cars();
        this.maxPosition = new CarPosition(0);
        findWinner(allCars);
    }

    private void findWinner(Cars allCars) {
        for (int carIndex = 0; carIndex < allCars.count(); carIndex++) {
            Car car = allCars.findOne(carIndex);
            checkWinner(car);
        }
    }

    private void checkWinner(Car car) {
        if(car.isOnlyWinner(maxPosition)){
            replaceWinner(car);
            return;
        }
        if(car.isSharedWinner(maxPosition)){
            addWinner(car);
        }
    }

    private void replaceWinner(Car car) {
        winnerCars = new Cars();
        winnerCars.add(car);
        maxPosition = car.getPosition();
    }

    private void addWinner(Car car) {
        winnerCars.add(car);
    }

    public String getNames(){
        StringJoiner winnerNames = new StringJoiner(WINNER_NAMES_DELEMETER);
        for (int i = 0; i < winnerCars.count(); i++) {
            winnerNames.add(winnerCars.findOneName(i));
        }
        return winnerNames.toString();
    }
}
