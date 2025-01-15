package MjLee.cafeMenuService.service;

import MjLee.cafeMenuService.domain.Menu;
import MjLee.cafeMenuService.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MenuService {
    MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public Menu saveMenu(Menu menu){
        return menuRepository.save(menu);
    }


    public void deleteMenu(String name){
        menuRepository.deleteMenuByName(name);
    }


    public void modifyMenuName(String oldName,String newName){
        if(menuRepository.findMenuByName(oldName).isEmpty()){
            System.out.println("존재하지 않는 메뉴입니다. 다시 확인해 주세요");
            return;
        }

        Menu menu = menuRepository.findMenuByName(oldName).get();
        menu.setName(newName);

    }


    public void modifyMenuPriceByName(String name, int changePrice){
        if(menuRepository.findMenuByName(name).isEmpty()){
            System.out.println("존재하지 않는 메뉴입니다. 다시 확인해 주세요");
            return;
        }

        Menu menu = menuRepository.findMenuByName(name).get();
        menu.setPrice(changePrice);

    }

    public Optional<Menu> findMenusByPrice(int price){

        if(menuRepository.findAllByPrice(price).isEmpty()){
            System.out.println("해당하는 금액의 메뉴가 존재하지 않습니다. 다시 확인해 주세요");
            return Optional.empty();
        }

        else return menuRepository.findAllByPrice(price);
    }

    public List<Menu> showAllMenus(){
        return menuRepository.findAll() ;
    }

}
