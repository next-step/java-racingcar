package racingcarwinner;

public class WinnerPicker {

    private WinnerPicker() {}

    public static void pickWinner(){
        Winner.addWinner(Cars.getCar(0).getName());

        for (int i = 1; i < Cars.getCarsCount(); i++) {
            figureOutWinner(Cars.getCar(i-1), Cars.getCar(i));
        }

    }

    public static void figureOutWinner(Car firstCar, Car secondCar){
        if(firstCar.getTravelDistance() < secondCar.getTravelDistance()){
            Winner.clearWinner();
            Winner.addWinner(secondCar.getName());
        }
        if(firstCar.getTravelDistance() == secondCar.getTravelDistance()){
            Winner.addWinner(secondCar.getName());
        }
    }
}
