import controller.ExitController;
import controller.MainController;
import controller.OrderController;
import controller.PaymentController;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        MainController mainController = new MainController(
                List.of(new OrderController(), new PaymentController(), new ExitController()));
        mainController.run();
//        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);
//
//        final int tableNumber = InputView.inputTableNumber();
//
//        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
    }
}
