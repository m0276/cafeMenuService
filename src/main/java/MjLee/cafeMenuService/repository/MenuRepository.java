package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String>{
    Optional<Menu> findMenuByName(String name);
    Optional<Menu> findAllByPrice(int price);
    void deleteMenuByName(String name);
    List<Menu> findAll();
}
