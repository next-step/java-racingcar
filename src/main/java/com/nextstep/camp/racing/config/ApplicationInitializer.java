package com.nextstep.camp.racing.config;

import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.application.dto.RacingResponse;
import com.nextstep.camp.racing.application.mapper.ViewDataMapper;
import com.nextstep.camp.racing.infrastructure.view.ViewData;
import com.nextstep.camp.racing.infrastructure.view.handler.CreateRacingViewHandler;
import com.nextstep.camp.racing.infrastructure.view.handler.RacingResultViewHandler;
import com.nextstep.camp.racing.presentation.RacingController;

public class ApplicationInitializer {

    private final ApplicationContext context;

    private ApplicationInitializer() {
        this.context = ApplicationContext.getInstance();
    }

    public static void initialize() {
        new ApplicationInitializer().run();
    }

    public void run() {
        CreateRacingViewHandler createRacingViewHandler = context.getBean(CreateRacingViewHandler.class);
        RacingController controller = context.getBean(RacingController.class);
        RacingResultViewHandler resultViewHandler = context.getBean(RacingResultViewHandler.class);

        ViewData requestViewData = createRacingViewHandler.handleUserInput();
        RacingRequest request = ViewDataMapper.toRacingRequest(requestViewData);
        RacingResponse response = controller.startRace(request);
        ViewData viewData = ViewDataMapper.toViewData(response);
        resultViewHandler.handleViewData(viewData);

    }
}
