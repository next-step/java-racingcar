package step4.view;

import java.util.List;

public class ResultView {
    /**
     * 자동차 거리를 화면에 출력한다.
     * @param distance
     */
    public String printDistance(int distance) {
        StringBuilder sb = new StringBuilder();

        while (distance-- > 0) {
            sb.append("-");
        }

        return sb.toString();
    }


    /**
     * 게임 결과를 보여준다.
     * @param results
     */
    public void showResult(List<String> results, int carCnt){
        for (int i=0; i<results.size(); i++) {
            String[] result = results.get(i).split("/");
            String move = printDistance(Integer.parseInt(result[1]));
            System.out.println(result[0] + " : " + move);
            if ((i+1)%carCnt == 0) {
                System.out.println();
            }
        }


    }

    /**
     * 우승자를 보여준다.
     * @param winners
     */
    public void showWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();

        for (String name : winners) {
            sb.append(name+",");
        }

        String winnerName = sb.toString();
        //마지막 쉼표 제거
        winnerName = winnerName.substring(0, winnerName.length()-1);

        System.out.println(winnerName + " 가 우승하였습니다.");

    }
}
