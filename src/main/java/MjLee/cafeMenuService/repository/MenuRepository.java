package MjLee.cafeMenuService.repository;

import MjLee.cafeMenuService.domain.Menu;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Transactional
@Repository
public interface MenuRepository extends JpaRepository<Menu, String>{
    Optional<Menu> findMenuByName(String name);
    List<Menu> findAllByPrice(int price);
    void deleteMenuByName(String name);
}
