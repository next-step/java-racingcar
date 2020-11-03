package StringInputCalcualtor;

import lombok.AllArgsConstructor;
import utils.StandardIoUtils;

@AllArgsConstructor
public class ArgumentCollector {
    private String[] args;

    public String collect() {
        if (args.length > 0) {
            return String.join(" ", args);
        }
        return StandardIoUtils.input("문자열 수식을 입력 하세요");
    }
}
