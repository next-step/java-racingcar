package stage4.view;

import stage4.dto.ResultValue;

import java.util.List;

public class ResultView {

    private void printNotice() {
        System.out.println("실행 결과");
    }

    public void printResult(int carNum, List<ResultValue> results) {
        printNotice();
        for (int i = 1; i <= results.size(); i++) {
            final ResultValue resultValue = results.get(i - 1);
            changePrintFormat(resultValue.getCarName(), resultValue.getCurrentStatus());
            if (i % carNum == 0) System.out.println();
        }
    }

    public void changePrintFormat(String carName, int carStatus) {
        StringBuffer sb = new StringBuffer();
        sb.append(carName).append(" : ");
        for (int i = 0; i < carStatus; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

    public void printWinner(List<ResultValue> resultWinnerList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultWinnerList.size(); i++) {
            sb.append(resultWinnerList.get(i).getCarName());
            final int lastIndex = resultWinnerList.size() - 1;
            this.addDelimiter(lastIndex, sb, i);
        }
        sb.append("(이)가 최종 우승했습니다.");
        System.out.println(sb);
    }

    private void addDelimiter(int lastIndex, StringBuilder sb, int i) {
        if (i != lastIndex) {
            sb.append(", ");
        }
    }
}