package com.nextstep.camp.racing.infrastructure.view;

import java.util.Scanner;

import com.nextstep.camp.racing.common.utils.NumberUtils;

public class QuantityInput extends AbstractInput {

    private QuantityInput() {
        super();
    }

    private QuantityInput(Scanner scanner) {
        super(scanner);
    }

    public static QuantityInput create() {
        return new QuantityInput();
    }

    public static QuantityInput create(Scanner scanner) {
        return new QuantityInput(scanner);
    }

    @Override
    public String getLabel() {
        return "자동차 대수는 몇 대 인가요?";
    }

    @Override
    public String getName() {
        return "quantity";
    }

    @Override
    protected boolean isValid(String value) {
        if (NumberUtils.isNotNumber(value)) {
            return false;
        }
        int intValue = Integer.parseInt(value);
        return NumberUtils.isPositiveNumber(intValue) || NumberUtils.isZero(intValue);
    }
}
