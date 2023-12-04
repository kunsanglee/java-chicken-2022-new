package controller;

import view.MainMenu;

public class ExitController extends PosController {

    @Override
    public boolean isAcceptable(MainMenu mainMenu) {
        return MainMenu.EXIT.equals(mainMenu);
    }

    @Override
    public MainMenu process() {
        return MainMenu.EXIT;
    }
}
