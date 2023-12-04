package controller;

import domain.Menu;
import domain.OrderRepository;
import domain.Payment;
import domain.Table;
import domain.TableRepository;
import java.util.Map;
import view.InputView;
import view.MainMenu;
import view.OutputView;

public class PaymentController extends PosController {

    @Override
    public boolean isAcceptable(MainMenu mainMenu) {
        return MainMenu.PAYMENT.equals(mainMenu);
    }

    @Override
    public MainMenu process() {
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTable(tableNumber);
        Map<Menu, Integer> orderMenu = OrderRepository.getTableOrderMenu(table);
        OutputView.printOrderMenu(orderMenu);

        // 신용카드 현금 입력받기
        Payment payment = Payment.of(InputView.inputPayment());
        double tableTotalPrice = OrderRepository.getTableTotalPrice(table);
        if (payment.equals(Payment.CASH)) {
            // 할인
            tableTotalPrice = tableTotalPrice * 0.95;
        }
        OutputView.printTotalPrice(tableTotalPrice);
//        OrderRepository.pay(table);
        return MainMenu.PAYMENT;
    }
}
