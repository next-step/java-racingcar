package racing;

public class RacingCar {

    public static void main(String[] args) throws Exception {
//        racingCar();
        racingCarWithName();
    }

    public static void racingCar() {
        ResultView.print("자동차 대수는 몇 대 인가요?");
        int cars = InputView.input();
        ResultView.print("시도할 회수는 몇 회 인가요?");
        int round = InputView.input();

        Racing racing = new Racing(cars, round);
        ResultView.print("실행 결과");
        racing.race();
    }

    public static void racingCarWithName() throws Exception {
        ResultView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = InputView.inputString();
        String[] cars = carNames.split(",");
        for (String car : cars) {
            checkName(car);
        }
        ResultView.print("시도할 회수는 몇회인가요?");
        int round = InputView.input();

        Racing racing = new Racing(cars, round);
        ResultView.print("");
        ResultView.print("실행결과");
        racing.race();
        racing.winner();
    }

    private static void checkName(String car) throws Exception {
        if (car.length() > 5) {
            throw new Exception("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
