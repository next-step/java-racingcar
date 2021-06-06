package racing;

import java.util.List;

public class PrintResult {

    public void printPlayers(Car aCar) {
        System.out.print(aCar.getName() + " : ");
        printTrace(aCar);
        System.out.println();
    }

    public void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<String> winners) {

        System.out.print("최종 우승자: ");

        System.out.print(String.join(", ", winners));

        System.out.println();

    }
}
