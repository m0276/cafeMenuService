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
        if(menuRepository.findMenuByName(menu.getName()).isEmpty()){
            menuRepository.save(menu);
        }

        return menu;
    }


    public boolean deleteMenu(String name){
        if(menuRepository.findMenuByName(name).isEmpty()) return false;
        else{
            menuRepository.deleteMenuByName(name);
            return true;
        }
    }


    public int modifyMenuName(String oldName,String newName){
        if(menuRepository.findMenuByName(newName).isPresent()){
            return 1;
        }
        else if(menuRepository.findMenuByName(oldName).isEmpty()){
            return -1;
        }

        Menu menu = menuRepository.findMenuByName(oldName).get();
        menu.setName(newName);

        menuRepository.save(menu);
        return 0;
    }


    public boolean modifyMenuPriceByName(String name, int changePrice){
        if(menuRepository.findMenuByName(name).isEmpty()){
            return false;
        }

        Menu menu = menuRepository.findMenuByName(name).get();
        menu.setPrice(changePrice);

        menuRepository.save(menu);
        return true;
    }

    public List<Menu> findMenusByPrice(int price){

        if(menuRepository.findAllByPrice(price).isEmpty()){
            return null;
        }

        else return menuRepository.findAllByPrice(price);
    }

    public Menu findMenuByName(String name){
        if(menuRepository.findMenuByName(name).isEmpty()){
            return null;
        }
        else{
            return (Menu) menuRepository.findMenuByName(name).get();
        }

    }

    public List<Menu> showAllMenus(){
        return menuRepository.findAll() ;
    }

    public void deleteAll() {
        menuRepository.deleteAll();
    }
}
