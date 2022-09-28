package ThirdStep.domain.model.request;

import java.util.List;

public class SettingRequest {
    private final List<CarRequest> carRequests;
    private final int attempts;

    public SettingRequest(List<CarRequest> carRequests, int attempts) {
        this.carRequests = carRequests;
        this.attempts = attempts;
    }

    public List<CarRequest> getCarRequests() {
        return carRequests;
    }

    public int getAttempts() {
        return attempts;
    }
}
