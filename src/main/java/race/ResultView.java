package race;

import java.util.List;

public class ResultView {

    public void printCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
    }

    public void printTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과\n");
    }

    public void showResult(List<Integer> carList, String sign) {
        for (int i=0; i<carList.size(); i++) {
            System.out.println(sign.repeat(carList.get(i)));
        }
    }
}
