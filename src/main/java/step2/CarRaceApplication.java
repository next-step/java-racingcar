package step2;

public class CarRaceApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        startRace(numberOfCars, numberOfTrials);

        System.out.println();
        System.out.println("실행 결과");
    }


}
