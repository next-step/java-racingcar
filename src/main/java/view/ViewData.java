package view;

import java.util.Map;

public class ViewData {
    private final Map<String, String> data;

    private ViewData(Map<String, String> data) {
        this.data = data;
    }

    public static ViewData of(Map<String, String> data) {
        return new ViewData(data);
    }

    public String get(String key) {
        return data.get(key);
    }
}