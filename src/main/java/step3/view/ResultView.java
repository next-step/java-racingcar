package step3.view;

import java.util.List;

public class ResultView {
    /**
     * 게임 결과를 보여준다.
     * @param results
     */
    public void showResult(List<String> results, int carCnt){
        results.stream()
                .forEach(str -> {
                    String[] result = str.split("/");
                    String move = printDistance(Integer.parseInt(result[2]));
                    System.out.println(result[0] + "번차 랜덤숫자 : " + result[1] + " " + move);
                    if (Integer.parseInt(result[0]) == carCnt) {
                        System.out.println();
                    }
                });
    }


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
}
