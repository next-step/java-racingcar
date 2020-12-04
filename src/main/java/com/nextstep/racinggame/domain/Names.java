package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidNamesException;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static final int MIN_SIZE = 0;

    private final List<Name> names;

    public Names(final List<Name> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(final List<Name> names) {
        if (names.size() <= MIN_SIZE) {
            throw new InvalidNamesException("최소 1개 이상의 Name이 있어야 합니다.");
        }
    }
}
