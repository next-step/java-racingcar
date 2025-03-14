package com.nextstep.camp.racing.config;

import java.util.HashMap;
import java.util.Map;

import com.nextstep.camp.racing.application.RacingService;
import com.nextstep.camp.racing.infrastructure.view.CreateRacingViewHandler;
import com.nextstep.camp.racing.presentation.RacingController;

public class ApplicationContext {

    private static final ApplicationContext instance = new ApplicationContext();
    private final Map<Class<?>, Object> beans = new HashMap<>();

    private ApplicationContext() {
        register(CreateRacingViewHandler.class, new CreateRacingViewHandler());
        register(RacingService.class, new RacingService());
        register(RacingController.class, new RacingController(getBean(RacingService.class)));
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public <T> void register(Class<T> type, T instance) {
        beans.put(type, instance);
    }

    public <T> T getBean(Class<T> type) {
        return type.cast(beans.get(type));
    }
}
