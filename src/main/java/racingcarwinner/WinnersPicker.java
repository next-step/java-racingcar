package racingcarwinner;

public class WinnersPicker {
    private static int winnersPositionValue;
    private final static Winners winners = new Winners();

    public static Winners winnersPick(Cars cars) {

         winnersPositionValue = cars.getCar(0).getPosition().getValue();

        winners.addWinner(cars.getCar(0).getName().getString());

        for (int i = 0; i < cars.getCount() - 1; i++) {

            Car carToCompare = cars.getCar(i+1);

            int positionToCompareValue = carToCompare.getPosition().getValue();

            isLarger(positionToCompareValue, carToCompare);
            isSame(positionToCompareValue, carToCompare);

        }
        return winners;
    }

    private static void isLarger(int positionToCompareValue, Car car){
        if(winnersPositionValue < positionToCompareValue){
            winnersPositionValue = positionToCompareValue;
            winners.clearWinners();
            winners.addWinner(car.getName().getString());
        }
    }

    private static void isSame(int positionToCompareValue, Car car){
        if(winnersPositionValue == positionToCompareValue){
            winners.addWinner(car.getName().getString());
        }
    }

}
