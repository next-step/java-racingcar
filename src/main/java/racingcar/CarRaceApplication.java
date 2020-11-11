package racingcar;

public class CarRaceApplication {

    public static void main(String[] args){
        int carCnt = InputView.input("자동차 대수는 몇 대 인가요? ");
        int tryCnt = InputView.input("시도할 회수는 몇 회 인가요? ");
        CarRace carRace = new CarRace(carCnt, tryCnt);

        System.out.println("\n실행결과");

        carRace.race();

        ResultView.print(carRace);

    }

}
