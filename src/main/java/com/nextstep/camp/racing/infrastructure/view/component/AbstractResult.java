package com.nextstep.camp.racing.infrastructure.view.component;

import com.nextstep.camp.racing.infrastructure.view.Element;

public abstract class AbstractResult implements Element {
    protected final String value;

    protected static final String DEFAULT_VALUE = "";

    protected AbstractResult(String value) {
        this.value = value;
    }

    @Override
    public abstract void action();

    @Override
    public String getValue() {
        return value;
    }
}
