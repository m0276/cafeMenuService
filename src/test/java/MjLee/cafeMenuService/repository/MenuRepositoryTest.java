package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;


    @Test
    void testA(){
        //given
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        // when
        if (menuRepository.findMenuByName(menu.getName()).isEmpty()) {
            menuRepository.save(menu);
        }

        //then
        List<Menu> allMenus = menuRepository.findAll();
        System.out.println(allMenus);

    }

    @Test
    void testB() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);
        if (menuRepository.findMenuByName(menu.getName()).isEmpty()) {
            menuRepository.save(menu);
        }

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        if (menuRepository.findMenuByName(menu2.getName()).isEmpty()) {
            menuRepository.save(menu2);
        }

        System.out.println(menuRepository.findMenuByName("Menu2"));
    }

    @Test
    void testC() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);
        if (menuRepository.findMenuByName(menu.getName()).isEmpty()) {
            menuRepository.save(menu);
        }

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        if (menuRepository.findMenuByName(menu2.getName()).isEmpty()) {
            menuRepository.save(menu2);
        }

        menuRepository.deleteMenuByName("Menu1");

        System.out.println(menuRepository.findAll());
    }

    @Test
    void testD() {
        Menu menu = new Menu();
        menu.setName("Menu3");
        menu.setPrice(7000);
        if (menuRepository.findMenuByName(menu.getName()).isEmpty()) {
            menuRepository.save(menu);
        }

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        if (menuRepository.findMenuByName(menu2.getName()).isEmpty()) {
            menuRepository.save(menu2);
        }
        List<Menu> list = menuRepository.findAllByPrice(7000);

        System.out.println(list);
    }
}