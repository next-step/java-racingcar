package calcurator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Sign {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/");


    private String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public static List<String> getSignValues(){
        return Arrays.stream(values()).map((s) -> s.getSign()).collect(Collectors.toList());
    }


}
