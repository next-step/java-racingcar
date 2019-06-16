package step1;

import spark.utils.StringUtils;

public class Validator {

    public void stringValidation(String inputString) {
        if(StringUtils.isEmpty(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    public void operatorTypeValidation(String inputType) {
        if(!"+".equals(inputType)
                && !"-".equals(inputType)
                && !"*".equals(inputType)
                && !"/".equals(inputType)) {
            throw new IllegalArgumentException();
        }
    }
}
