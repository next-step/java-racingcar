package racing.view;

import racing.Car;

import java.util.List;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public void count() {
        System.out.println(COUNT_MESSAGE);
    }

    public void result() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public void win(List<String> winnerList) {
        System.out.print("\n" + WIN_MESSAGE);
        for (int i = 0; i < winnerList.size() - 1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(winnerList.size() - 1));
    }

    public void nowDistance(List<Car> carList) {
        System.out.println();
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName() + " : ");
            printDistance(carList.get(i).getMoveCount());
            System.out.println();
        }
    }

    private void printDistance(int count) {
        for (int j = 0; j < count; j++) {
            System.out.print("-");
        }
    }
}
