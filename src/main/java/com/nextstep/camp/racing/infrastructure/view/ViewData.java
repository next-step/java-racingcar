package com.nextstep.camp.racing.infrastructure.view;

import java.util.Map;

public class ViewData {
    private final Map<String, Object> data;

    private ViewData(Map<String, Object> data) {
        this.data = data;
    }

    public static ViewData of(Map<String, Object> data) {
        return new ViewData(data);
    }

    public Object get(String key) {
        return data.get(key);
    }
}