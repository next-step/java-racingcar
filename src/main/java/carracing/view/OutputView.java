package carracing.view;

import java.util.List;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printTrail(String name ,int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result+="-";
        }
        System.out.println(name+" : "+ result);
    }

    public void printBlank() {
        System.out.println("");
    }

    public void printWinner(List<String> winners) {
        String winnerList = "";

        for (String winner : winners) {
            winnerList = winnerList + winner + ", ";
        }
        winnerList = winnerList.substring(0, winnerList.length() - 2);
        System.out.println("우승자는 "+ winnerList +" 입니다.");
    }
}
