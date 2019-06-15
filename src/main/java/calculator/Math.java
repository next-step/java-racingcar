package calculator;

public enum Math {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String sign;

    Math(String sign) {
        this.sign = sign;
    }


    public String getSign(){
        return this.sign;
    }

}
