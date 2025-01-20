package MjLee.cafeMenuService.service;

import MjLee.cafeMenuService.domain.Menu;
import MjLee.cafeMenuService.repository.MenuRepository;
import jakarta.transaction.Transactional;
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

    @Test
    void saveMenu() {

        menuService.saveMenu("Menu1", 5000);

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void deleteMenu() {
        menuService.saveMenu("Menu1", 5000);

        menuService.saveMenu("Menu2", 5000);

        menuService.deleteMenu("Menu1");

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void modifyMenuName() {
        menuService.saveMenu("Menu1",5000);

        menuService.saveMenu("Menu2", 5000);

        menuService.modifyMenuName("Menu1","NewMenu");

        System.out.println(menuService.showAllMenus());
    }

    @Test
    void modifyMenuPriceByName() {
    }

    @Test
    void findMenusByPrice() {
    }

    @Test
    void showAllMenus() {
    }
}