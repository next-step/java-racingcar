package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.Scanner;

import com.nextstep.camp.racing.common.utils.NumberUtils;

public class MaxPositionInput extends AbstractInput {

    private MaxPositionInput() {
        super();
    }

    private MaxPositionInput(Scanner scanner) {
        super(scanner);
    }

    public static MaxPositionInput create() {
        return new MaxPositionInput();
    }

    public static MaxPositionInput create(Scanner scanner) {
        return new MaxPositionInput(scanner);
    }

    @Override
    public String getLabel() {
        return "시도할 회수는 몇 회 인가요?";
    }

    @Override
    public String getName() {
        return "maxPosition";
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
