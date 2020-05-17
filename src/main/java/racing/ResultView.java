package racing;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final List<String> messageList;

    public ResultView() {
        this.messageList = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messageList.add(message);
    }

    public void print() {
        for (String message : messageList) {
            System.out.println(message);
        }
    }
}
