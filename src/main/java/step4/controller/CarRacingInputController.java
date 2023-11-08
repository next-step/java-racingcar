package step4.controller;

public class CarRacingInputController {

    private final ScannerInterface myScanner;

    public CarRacingInputController(ScannerInterface myScanner) {
        this.myScanner = myScanner;
    }

    public int inputParticipantCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getScannerInt();
    }
    
    public int inputRacingChance() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getScannerInt();
    }

    private int getScannerInt() {
        try {
            int carCount = myScanner.getNextInt();

            if (isNegativeOrZeroNumber(carCount)) {
                throw new Exception();
            }

            return carCount;
        } catch (Exception e) {
            throw new RuntimeException("양의 정수 값만 가능합니다.");
        }
    }

    private boolean isNegativeOrZeroNumber(int number) {
        return number <= 0;
    }
}
