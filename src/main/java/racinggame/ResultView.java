package racinggame;

import java.util.List;

public class ResultView {
    private List<String> advanceStatus;

    public ResultView(List<String> advanceStatus) {
        this.advanceStatus = advanceStatus;
    }

    public void showAdvanceStatus() {
        for (String status : advanceStatus) {
            System.out.println(status);
        }
        System.out.println("");
    }
}
