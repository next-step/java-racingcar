package racing;

import racing.message.ViewMessage;

public class CarResultView {
    public void resultViewMessage() {
        System.out.println(ViewMessage.START_RESULT_VIEW.getMessage());
    }

    public String getLocationLineView(int location) {
        String result = "";
        for(int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }
}
