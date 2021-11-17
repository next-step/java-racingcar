package step4.dto;

import java.util.List;

public class CarNames {

    List<String> names;

    public CarNames(String text) {
        text.split(",");
    }
}
