package study.step3;

public class ResultView {

    public void printStateBoard(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.printPosition());
        }
        System.out.println();
    }

    public void printWinner(Car[] cars) {
        System.out.println(findWinners(cars) + "가 최종 우승했습니다.");
    }

    private String findWinners(Car[] cars) {
        Car winner = cars[0];
        String winnerNames = cars[0].getName();
        for (int i = 1; i < cars.length; i++) {
            winnerNames = isWinner(winnerNames, winner, cars[i]);
        }
        return winnerNames;
    }

    public String isWinner(String winnerNames, Car winner, Car compare) {
        if (winner.getPosition() > compare.getPosition()) {
            return winnerNames;
        }

        if (winner.getPosition() == compare.getPosition()) {
            return winnerNames + "," + compare.getName();
        }

        winner.updateInfo(compare.getName(), compare.getPosition());

        return compare.getName();
    }


}
