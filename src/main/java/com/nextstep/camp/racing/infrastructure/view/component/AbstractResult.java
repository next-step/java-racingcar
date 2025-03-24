package com.nextstep.camp.racing.infrastructure.view.component;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.infrastructure.view.Element;

public abstract class AbstractResult implements Element {
    protected final PositiveInteger value;

    protected static final PositiveInteger DEFAULT_VALUE = PositiveInteger.ZERO;

    protected AbstractResult(PositiveInteger value) {
        this.value = value;
    }

    @Override
    public abstract void action();

    @Override
    public PositiveInteger getValue() {
        return value;
    }
}
