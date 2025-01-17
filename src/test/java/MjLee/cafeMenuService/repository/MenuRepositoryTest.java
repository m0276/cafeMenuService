package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;

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

        //when
        menuRepository.save(menu);

        //then
        System.out.println(menuRepository.findAll());
    }

    @Test
    void testB() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);
        menuRepository.save(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        menuRepository.save(menu2);

        System.out.println(menuRepository.findMenuByName("Menu1"));
    }

    @Test
    void testC() {
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);
        menuRepository.save(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        menuRepository.save(menu2);

        menuRepository.deleteMenuByName("Menu1");

        System.out.println(menuRepository.findAll());
    }

    @Test
    void testD() {
        Menu menu = new Menu();
        menu.setName("Menu3");
        menu.setPrice(7000);
        menuRepository.save(menu);

        Menu menu2 = new Menu();
        menu2.setName("Menu2");
        menu2.setPrice(7000);
        menuRepository.save(menu2);

        System.out.println(menuRepository.findAllByPrice(7000));
    }
}