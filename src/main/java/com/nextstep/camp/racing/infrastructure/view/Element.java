package com.nextstep.camp.racing.infrastructure.view;

public interface Element<T> {
    void action();
    String getName();
    String getLabel();
    T getValue();
}

