package step4;

import java.util.ArrayList;
import java.util.List;

public class MockOutputView implements OutputView {
    private final List<String> outputs = new ArrayList<>();

    @Override
    public void print(String message) {
        outputs.add(message); // 출력 메시지를 리스트에 저장
    }

    public List<String> getOutputs() {
        return this.outputs;
    }
}