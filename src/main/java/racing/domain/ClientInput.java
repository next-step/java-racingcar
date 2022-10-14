package racing.domain;

import java.util.Objects;

public class ClientInput {
    private final String carNames;
    private final int tryCount;

    public ClientInput(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInput that = (ClientInput) o;
        return tryCount == that.tryCount && Objects.equals(carNames, that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, tryCount);
    }

    public static ClientInput.ClientInputBuilder builder() {
        return new ClientInput.ClientInputBuilder();
    }

    public static class ClientInputBuilder {
        private String carNames;
        private int tryCount;

        ClientInputBuilder() {
        }

        public ClientInput.ClientInputBuilder carNames(String carNames) {
            this.carNames = carNames;
            return this;
        }

        public ClientInput.ClientInputBuilder tryCount(int tryCount) {
            this.tryCount = tryCount;
            return this;
        }

        public ClientInput build() {
            return new ClientInput(this.carNames, this.tryCount);
        }
    }
}
