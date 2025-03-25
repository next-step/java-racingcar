package com.nextstep.camp.racing.infrastructure.view.component;

import com.nextstep.camp.racing.infrastructure.view.Element;

public abstract class AbstractResult<T> implements Element<T> {
    protected final String value;

    protected static final String DEFAULT_VALUE = "";

    protected AbstractResult(String value) {
        this.value = value;
    }

    @Override
    public abstract void action();
}
