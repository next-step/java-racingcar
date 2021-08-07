package stage4;

import java.util.List;

public class ResultView {

    private void printNotice() {
        System.out.println("실행 결과");
    }

    public void printResult(int carNum, List<ResultValue> results) {
        printNotice();
        for (int i = 1; i <= results.size(); i++) {
            changePrintFormat(results.get(i - 1).getCurrentStatus());
            if (i % carNum == 0) System.out.println();
        }
    }

    public void changePrintFormat(int carStatus) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < carStatus; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
}
