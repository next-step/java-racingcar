package step5.view;

public class CarRacingInputView {

    private final ScannerInterface myScanner;

    public CarRacingInputView(ScannerInterface myScanner) {
        this.myScanner = myScanner;
    }

    public InputDto inputRacingCondition() {
        String carNames = inputParticipantCarName();
        int racingChance = inputRacingChance();

        return new InputDto(carNames, racingChance);
    }

    private String inputParticipantCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return myScanner.getNext();
    }
    
    private int inputRacingChance() {
        System.out.println("시도할 회수는 몇회인가요?");
        return myScanner.getNextInt();
    }

    private boolean isNegativeOrZeroNumber(int number) {
        return number <= 0;
    }
}
