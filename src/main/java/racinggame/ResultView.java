package racinggame;

import java.util.List;

public class ResultView {
    private List<String> advanceStatus;

    public ResultView(List<String> advanceStatus) {
        this.advanceStatus = advanceStatus;
    }

    public void showAdvanceStatus() {
        System.out.println("실행결과");
        for (String status : advanceStatus) {
            System.out.println(status);
        }
    }
}
