package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    void save(){
        Menu menu = new Menu();
        menu.setName("Menu1");
        menu.setPrice(5000);

        menuRepository.save(menu);
    }

    @Test
    void findMenuByName() {
        System.out.println(menuRepository.findMenuByName("Menu1"));
    }

    @Test
    void findAllByPrice() {
    }

    @Test
    void deleteMenuByName() {
    }

    @Test
    void findAll(){
        System.out.println(menuRepository.findAll());
    }
}