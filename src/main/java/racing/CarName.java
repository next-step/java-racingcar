package racing;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name) || name.equals(""))
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
