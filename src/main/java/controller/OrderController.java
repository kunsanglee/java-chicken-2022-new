package controller;

import static controller.Retry.retry;
import static exception.ExceptionMessage.NOT_FOUND_MENU;
import static exception.ExceptionMessage.NOT_FOUND_TABLE;

import domain.Menu;
import domain.OrderRepository;
import domain.Table;
import view.InputView;
import view.MainMenu;
import view.OutputView;

public class OrderController extends PosController {

    @Override
    public boolean isAcceptable(MainMenu mainMenu) {
        return MainMenu.REGISTER_ORDER.equals(mainMenu);
    }

    @Override
    public MainMenu process() {
        Table findTable = retry(this::findTable);
        Menu orderMenu = retry(this::findMenu);
        int quantity = retry(InputView::inputOrderMenuQuantity);
        OrderRepository.add(findTable, orderMenu, quantity);
        return MainMenu.REGISTER_ORDER;
    }

    private Table findTable() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        return getTable(tableNumber);
    }

    private Menu findMenu() {
        OutputView.printMenus(menus);
        int orderMenuNumber = InputView.inputOrderMenuNumber();
        return getMenu(orderMenuNumber);
    }

    private Table getTable(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getNumber() == tableNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_TABLE.getMessage()));
    }

    private Menu getMenu(int orderMenuNumber) {
        return menus.stream()
                .filter(menu -> menu.getNumber() == orderMenuNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MENU.getMessage()));
    }
}
