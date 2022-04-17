package carrace;

public class ResultView {
    public void printCarRaceResult(CarRace carRace) {
        System.out.println("\n실행 결과");
        int index = 0;
        for (int result : carRace.getRecordCarRace().getRaceInfoBoards()) {
            printResultOfEachCar(result);
            index++;

            divideEndOfEachRace(index, carRace.getNumberOfCars());
        }
    }

    private void printResultOfEachCar(int result) {
        for (int i = 0; i < result; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void divideEndOfEachRace(int index, int numberOfCars) {
        if (index % numberOfCars == 0) {
            System.out.println();
        }
    }
}
