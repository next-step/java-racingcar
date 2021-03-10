package step_3;

import java.util.List;

public class RacingResult {
    private final List<Integer> carsOnCourse;
    private final Boolean complete;

    public List<Integer> gameStatus() {
        return carsOnCourse;
    }

    public boolean complete() {
        return this.complete;
    }

    private RacingResult(List<Integer> carsOnCourse, Boolean complete) {
        this.carsOnCourse = carsOnCourse;
        this.complete = complete;
    }

    public static class Builder {
        private List<Integer> carsOnLap;
        private Boolean complete = false;

        public Builder carsOnLap(List<Integer> carsOnLap) {
            this.carsOnLap = carsOnLap;
            return this;
        }

        public Builder complete(Boolean complete) {
            this.complete = complete;
            return this;
        }

        public RacingResult build() {
            return new RacingResult(carsOnLap, complete);
        }
    }
}
