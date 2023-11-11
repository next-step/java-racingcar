package com.racing.game.dto;

import java.util.List;

public class Winners {
    List<String> value;

    private Winners(List<String> value) {
        this.value = value;
    }

    public static Winners from(List<String> winners) {
        return new Winners(winners);
    }

    public String winnersName() {
        return toResultString();
    }

    private String toResultString() {
        return String.join(",", value);
    }
}
