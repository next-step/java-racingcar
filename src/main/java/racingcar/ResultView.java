package racingcar;

import java.util.*;

public class ResultView {

    public void printResult(Racing racing) {
        printInit();
        printGames(racing);
        printWinner(racing);
    }

    private void printInit() {
        System.out.println("실행결과");
    }

    private void printGames(Racing racing) {
        List<RaceRecord> records = racing.getRaceRecord();

        if (records.size() == 0) {
            return;
        }
        for (RaceRecord record : records) {
            printGame(record);
        }
    }

    private void printGame(RaceRecord record) {
        for (Map.Entry<String, Integer> entry : record.getResult().entrySet()) {
            System.out.print(entry.getKey() + " : ");
            printDistance(entry.getValue());
        }
        System.out.println();
    }

    private void printDistance(Integer result) {
        for (int i = 0; i < result; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printWinner(Racing racing) {
        List<Car> winners = racing.getWinner();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(winners.get(i).getName());
        }
        String names = sb.toString();
        System.out.println(names + "가 최종 우승했습니다.");

    }




}
