package Racing;


import java.util.*;

public class RacingView {
    Scanner scan = new Scanner(System.in);


    public String inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String str = scan.nextLine();

        return str;
    }

    public int inputNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = scan.nextInt();

        return num;
    }

    public void resultExecutionResult() {
        System.out.println("실행 결과");

    }

    public void resultOneExecutionResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int movingRange = car.getMovingRange();
            resultMovingRange(movingRange);
            System.out.println();
        }

        System.out.println();
    }

    private void resultMovingRange(int movingRange) {

        for (int i = 0; i < movingRange; i++) {
            System.out.print("-");
        }
    }

    public void resultWinner(List<String> winner) {
        System.out.print("최종 우승자: ");

        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            resultWinners(winner, i);
        }
    }

    private void resultWinners(List<String> winner, int i) {
        if (i != winner.size() - 1) {
            System.out.print(", ");
        }
    }
}
