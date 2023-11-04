package step3;

public class InputView {

    private final ScannerInterface myScanner;

    public InputView(ScannerInterface myScanner) {
        this.myScanner = myScanner;
    }

    public int setParticipantCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = getScannerInt();
        checkPositiveNumber(carCount);
        return carCount;
    }
    
    public int setRacingChance() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingChance = getScannerInt();
        checkPositiveNumber(racingChance);
        return racingChance;
    }

    private int getScannerInt() {
        try {
            String inputString = myScanner.getNext();
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            throw new RuntimeException("양의 정수 값만 가능합니다.");
        }
    }

    private void checkPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값은 불가능합니다.");
        }
    }
}
