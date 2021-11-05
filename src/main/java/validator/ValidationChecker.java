package validator;

import java.util.*;

public class ValidationChecker {

    private final List<IValidator> validators;

    public ValidationChecker(List<IValidator> validators) {
        this.validators = validators;
    }

    public void check(String input) {
        for(IValidator validator : validators){
            validator.check(input);
        }
    }
}