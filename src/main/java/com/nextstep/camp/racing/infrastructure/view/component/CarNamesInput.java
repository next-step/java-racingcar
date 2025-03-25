package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.Scanner;

import com.nextstep.camp.racing.domain.vo.CarNames;

public class CarNamesInput extends AbstractInput<CarNames> {

    private CarNamesInput() {
        super();
    }

    private CarNamesInput(Scanner scanner) {
        super(scanner);
    }

    public static CarNamesInput create() {
        return new CarNamesInput();
    }

    public static CarNamesInput create(Scanner scanner) {
        return new CarNamesInput(scanner);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getLabel() {
        return "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    }

    @Override
    public CarNames getValue() {
        return CarNames.of(untypedValue);
    }

    @Override
    protected boolean isValid(String value) {
        return true;
    }
}
