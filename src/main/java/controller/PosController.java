package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.MainMenu;

public abstract class PosController {
    final List<Table> tables = TableRepository.tables();
    final List<Menu> menus = MenuRepository.menus();
    final OrderRepository orderRepository = new OrderRepository();

    abstract boolean isAcceptable(MainMenu mainMenu);

    abstract MainMenu process();
}
