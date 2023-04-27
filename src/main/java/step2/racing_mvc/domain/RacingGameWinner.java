package step2.racing_mvc.domain;

import java.util.StringJoiner;

public class RacingGameWinner {
    private RacingCars winnerCars;
    private RacingCarPosition maxPosition;
    private static String WINNER_NAMES_DELEMETER = ", ";

    public RacingGameWinner(RacingCars allCars){
        validateCars(allCars);
        this.winnerCars = new RacingCars();
        this.maxPosition = new RacingCarPosition(0);
        findWinner(allCars);
    }

    private void validateCars(RacingCars allCars) {
        if (allCars.empty()){
            throw new IllegalArgumentException("경주 중인 자동차가 없습니다.");
        }
    }

    private void findWinner(RacingCars allCars) {
        for (int carIndex = 0; carIndex < allCars.count(); carIndex++) {
            RacingCar car = allCars.findOne(carIndex);
            checkWinner(car);
        }
    }

    private void checkWinner(RacingCar car) {
        if(car.isOnlyWinner(maxPosition)){
            replaceWinner(car);
            return;
        }
        if(car.isSharedWinner(maxPosition)){
            addWinner(car);
        }
    }

    private void replaceWinner(RacingCar car) {
        winnerCars = new RacingCars();
        winnerCars.add(car);
        maxPosition = car.getPosition();
    }

    private void addWinner(RacingCar car) {
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