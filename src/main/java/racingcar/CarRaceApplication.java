package racingcar;

public class CarRaceApplication {

    public static void main(String[] args) throws Exception {
        String[] carNames = InputView.inputCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ");
        int tryCnt = InputView.input("시도할 회수는 몇 회 인가요? ");
        CarRace carRace = new CarRace(carNames, tryCnt);

        System.out.println("\n실행결과");

        carRace.race();

        ResultView.print(carRace);
        ResultView.printWinner(carRace.getWinnerCars());
    }

}
