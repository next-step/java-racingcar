package racingcar;

import java.util.List;

public class ResultView {

    public void showResult(Car car) {
        System.out.println(car.getCarName() + ": ");
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinner(List<String> winnerList) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winnerList.size(); i++) {
            builder.append(winnerList.get(i));
            builder.append(", ");
        }

        String result = builder.toString();
        int lastIndex = result.lastIndexOf(",");
        result = result.substring(0, lastIndex);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
