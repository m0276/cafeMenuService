package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    @AfterEach
    void clear(){
        menuRepository.deleteAll();
    }

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
}