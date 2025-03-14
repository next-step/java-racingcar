package com.nextstep.camp.racing.config;

import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.application.dto.RacingResponse;
import com.nextstep.camp.racing.application.mapper.RequestMapper;
import com.nextstep.camp.racing.presentation.RacingController;
import com.nextstep.camp.racing.infrastructure.view.CreateRacingViewHandler;
import com.nextstep.camp.racing.infrastructure.view.ViewData;

public class ApplicationInitializer {

    private final ApplicationContext context;

    private ApplicationInitializer() {
        this.context = ApplicationContext.getInstance();
    }

    public static void initialize() {
        new ApplicationInitializer().run();
    }

    public void run() {
        CreateRacingViewHandler viewHandler = context.getBean(CreateRacingViewHandler.class);
        RacingController controller = context.getBean(RacingController.class);

        ViewData viewData = viewHandler.handleUserInput();
        RacingRequest request = RequestMapper.toRacingRequest(viewData);
        RacingResponse racingResponse = controller.startRace(request);
    }
}
