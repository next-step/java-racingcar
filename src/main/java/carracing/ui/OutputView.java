package carracing.ui;

import carracing.dto.CarRaceResponse;

public class OutputView {

    public static void output(CarRaceResponse response) {
        printHeader();
        newLine();
        response.getCarResponses().forEach(carsResponse -> {
            System.out.println(carsResponse.getCarsInfo());
        });
    }

    private static void printHeader() {
        System.out.println("실행 경과");
    }

    private static void newLine() {
        System.out.println("\n");
    }
}
