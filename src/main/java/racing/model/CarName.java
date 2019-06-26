package racing.model;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name))
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
