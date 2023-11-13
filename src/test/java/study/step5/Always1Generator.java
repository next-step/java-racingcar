package study.step5;

import study.step5.domain.NumberGenerator;

public class Always1Generator implements NumberGenerator {

    @Override
    public int generate() {
        return 1;
    }
}
