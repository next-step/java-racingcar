package com.ssabae.nextstep.racingcar.step03.domain;

import com.ssabae.nextstep.racingcar.step03.validate.BlankStringValidator;
import com.ssabae.nextstep.racingcar.step03.validate.StringLengthValidator;
import com.ssabae.nextstep.racingcar.step03.validate.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
public class CarNameValidator implements Validator<String> {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final List<Validator<String>> validators;

    public CarNameValidator() {
        validators = new ArrayList<>();
        validators.add(new BlankStringValidator());
        validators.add(new StringLengthValidator(CAR_NAME_MIN_LENGTH, CAR_NAME_MAX_LENGTH));
    }

    @Override
    public boolean isValid(String str) {
        return validators.stream()
                .allMatch(validator -> validator.isValid(str));
    }
}
