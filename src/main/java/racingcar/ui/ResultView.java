/*
 * 자동차 경주의 출력을 담당하는 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package racingcar.ui;

import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ResultView {

    public static void printForward(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(ArrayList<Position> result) {
        result.forEach(num -> {
            printForward(num.getPosition());
        });
    }

    public static void printAllResultWithName(ArrayList<Map<Name, Position>> results){
        System.out.println("실행 결과");
        results.forEach(ResultView::printResultWithName);
    }

    public static void printResultWithName(Map<Name, Position> result) {
        result.forEach((name, forwardNum) -> {
            System.out.print(name + " : ");
            printForward(forwardNum.getPosition());
        });
        System.out.println();
    }

    public static void printWinner(Set<Name> winners) {
        String winner = winners.toString();
        System.out.println(winner.substring(1, winner.length() - 1) + "가 최종 우승 했습니다.");
    }
}
