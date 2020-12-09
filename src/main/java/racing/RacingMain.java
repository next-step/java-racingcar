package racing;

public class RacingMain {
    public static void main(String[] args) {
        Display display = new Display();
        InputUtil inputUtil = new InputUtil();

        display.printLine("자동차 이름들을 입력하세요.");
        String[] participateCarsName = inputUtil.inputCarsName();
        ParticipateCars participateCars = new ParticipateCars(participateCarsName);

        display.printLine("자동차 경주의 수는 몇 번 인가요?");
        int tryNumber = new NumberParserUtil().toInt(inputUtil.inputNumber());
        CarRacing carRacing = new CarRacing(participateCars, display);
        carRacing.startRacing(tryNumber);
        display.printWinnner( carRacing.presentWinner());
    }
}
