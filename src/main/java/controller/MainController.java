package controller;

import static controller.Retry.retry;
import static exception.ExceptionMessage.NOT_FOUND_INPUT_MAIN_MENU;

import java.util.List;
import view.InputView;
import view.MainMenu;
import view.OutputView;

public class MainController {
    private final List<PosController> posControllers;

    public MainController(List<PosController> posControllers) {
        this.posControllers = posControllers;
    }

    public void run() {
        MainMenu status;
        do {
            status = retry(this::process);
        } while (status.isContinue());
    }

    private MainMenu process() {
        OutputView.printMenuNumber();
        MainMenu mainMenu = InputView.inputMenuNumber();
        PosController posController = posControllers.stream()
                .filter(service -> service.isAcceptable(mainMenu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_INPUT_MAIN_MENU.getMessage()));
        return posController.process();
    }
}
