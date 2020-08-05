package racing.view;

import racing.message.ViewMsg;

public class ResultView {
    public void viewResultMsg() {
        System.out.println(ViewMsg.RESULT_VIEW_START.getMsg());
    }

    public String getLocationVisualization(int location) {
        String result = "";
        for (int i=0; i<location; i++) {
            result += "-";
        }
        return result;
    }
}
