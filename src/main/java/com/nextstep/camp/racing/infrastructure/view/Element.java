package com.nextstep.camp.racing.infrastructure.view;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public interface Element {
    void action();
    String getName();
    String getLabel();
    PositiveInteger getValue();
}

