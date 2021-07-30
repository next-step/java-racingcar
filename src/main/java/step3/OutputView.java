package step3;

public class OutputView {

    public static void printResult(RacingCars racingCars, int tries) {
        System.out.println("실행 결과");
        printStatus(racingCars, tries);
    }

    private static void printStatus(RacingCars racingCars, int tries) {
        System.out.println(racingCars.getStatus());
        for (int i = 0; i < tries - 1; i++) {
            racingCars.run();
            System.out.println(racingCars.getStatus());
        }
    }
    
}
