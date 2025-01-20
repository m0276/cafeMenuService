package MjLee.cafeMenuService.service;

import MjLee.cafeMenuService.domain.Menu;
import MjLee.cafeMenuService.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MenuServiceTest {
    @Autowired
    private MenuService menuService;

    @AfterEach
    void clear(){
        menuService.deleteAll();
    }

    @Test
    void saveMenu() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuService.saveMenu(menu);

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void deleteMenu() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuService.saveMenu(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(5000);

        menuService.saveMenu(menu2);

        menuService.deleteMenu("Menu1");

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void modifyMenuName() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuService.saveMenu(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(5000);

        menuService.saveMenu(menu2);

        menuService.modifyMenuName("Menu1","NewMenu");

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void modifyMenuPriceByName() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuService.saveMenu(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(5000);

        menuService.saveMenu(menu2);

        menuService.modifyMenuPriceByName("Menu1",7000);

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void findMenusByPrice() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuService.saveMenu(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(5000);

        menuService.saveMenu(menu2);

        menuService.findMenusByPrice(5000);

        System.out.println(menuService.showAllMenus());
    }

}