package racingcarrefectoring.model;

public class WinnersPicker {

    private static Winners winners = new Winners();
    private static int winnersPositionValue = 0;

    public static Winners winnersPick(Cars cars){


        winners.addWinner(cars.getCar(0).getName());

        for (int i = 0; i < cars.getCount(); i++) {
            int valueToCompare = cars.getCar(i).getPosition().getValue();

            ComparePositionValue(valueToCompare, cars.getCar(i));
        }
        return winners;
    }

    public static void ComparePositionValue( int valueToCompare, Car car){
        if(winnersPositionValue == valueToCompare){
            winners.addWinner(car.getName());
        }

        if(winnersPositionValue < valueToCompare){
            winners.winnersClear();
            winners.addWinner(car.getName());
            winnersPositionValue = valueToCompare;
        }
    }
}
