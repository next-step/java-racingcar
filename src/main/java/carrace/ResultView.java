package carrace;

public class ResultView {
    public void printCarRaceResult(CarRace carRace) {
        System.out.println("\n실행 결과");
        int index = 0;
        for (int result : carRace.getRecordCarRace().getRaceInfoBoards()) {
            printResultOfEachCar(result, getCarName(carRace, index));
            index++;

            divideEndOfEachRace(index, carRace.getNumberOfCars());
        }

        printWinners(carRace);
    }

    private String getCarName(CarRace carRace, int index) {
        return carRace.getCars().get(index % carRace.getNumberOfCars()).getName();
    }

    private void printResultOfEachCar(int result, String carName) {
        System.out.print(carName + " : ");
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

    private void printWinners(CarRace carRace) {
        int i = 0;
        for (Car car : carRace.getRaceWinner().getWinners()) {
            printCommoa(i++);
            System.out.print(car.getName());
        }
        System.out.println("가 우승했습니다.");
    }

    private void printCommoa(int i) {
        if (i != 0) {
            System.out.print(", ");
        }
    }
}
