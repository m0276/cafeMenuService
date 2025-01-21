package MjLee.cafeMenuService.controller;

import MjLee.cafeMenuService.domain.Menu;
import MjLee.cafeMenuService.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {
    MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/menus/new")
    public String createForm(){
        return "menus/createMenu/createMenu";
    }

    @PostMapping("/menus/new")
    public String create(CreateMenu form){

        if(form.getName().isEmpty() && (form.getPrice() == null || form.getPrice() == 0)){
            return "menus/error/emptyInput";
        }
        else if(form.getName().isEmpty()){
            return "menus/error/emptyInputName";
        }
        else if(form.getPrice() == null || form.getPrice() == 0){
            return "menus/error/emptyInputPrice";
        }
        Menu menu = new Menu();
        menu.setName(form.getName());
        menu.setPrice(form.getPrice());

        menuService.saveMenu(menu);

        return "menus/completeProcess";
    }

    @GetMapping("/menus/modify")
    public String modify(){
        return "menus/modifyMenu/modify";
    }

    @GetMapping("/menus/modifyName")
    public String modifyForm(){
        return "menus/modifyMenu/modifyMenuName";
    }

    @PostMapping("/menus/modifyName")
    public String modifyMenuName(ModifyMenuName form){
        if(form.getName().isEmpty() && form.getNewName().isEmpty()){
            return "menus/error/emptyInput";
        }
        else if(form.getName().isEmpty() || form.getNewName().isEmpty()){
            return "menus/error/emptyInputName";
        }

        int  check = menuService.modifyMenuName(form.getName(),form.getNewName());
        if(check == -1){
            return "menus/error/errorPage";
        }
        else if(check == 1){
            return "menus/error/errorPageName";
        }

        return "menus/completeProcess";
    }

    @GetMapping("/menus/modifyPrice")
    public String modifyPriceFrom(){
        return "menus/modifyMenu/modifyMenuPrice";
    }

    @PostMapping("/menus/modifyPrice")
    public String modifyMenuPrice(ModifyMenuPrice form){
        if(form.getName().isEmpty() && (form.getPrice() == null || form.getPrice() == 0)){
            return "menus/error/emptyInput";
        }
        else if(form.getName().isEmpty()){
            return "menus/error/emptyInputName";
        }
        else if(form.getPrice() == null || form.getPrice() == 0){
            return "menus/error/emptyInputPrice";
        }

        boolean check = menuService.modifyMenuPriceByName(form.getName(),form.getPrice());

        if(!check){
            return "menus/error/errorPage";
        }
        return "menus/completeProcess";
    }
    
    @GetMapping("/menus/delete")
    public String deleteForm(){
        return "menus/deleteMenu/deleteMenu";
    }

    @PostMapping("/menus/delete")
    public String modify(DeleteMenu form){
        if(form.getName() == null){
            return "menus/error/errorPage";
        }
        boolean check = menuService.deleteMenu(form.getName());
        if(!check){
            return "menus/error/errorPage";
        }
        return "menus/completeProcess";
    }

    @GetMapping("/menus/showAllMenu")
    public String showAllMenu(Model model){
        List<Menu> list = menuService.showAllMenus();
        model.addAttribute(list);
        return"menus/allMenus/menuList";
    }

    @GetMapping("/menus/findMenu")
    public String findMenu(){
        return "menus/findMenu/findMenu";
    }

    @GetMapping("/menus/findMenu/findMenuByName")
    public String findMenuByName(){
        return "/menus/findMenu/findMenuByName";
    }

    @PostMapping("/menus/findMenu/findMenuByName")
    public String menuFound(String name, Model model){
        Menu menu = menuService.findMenuByName(name);
        if(menu == null){
            return "menus/error/errorPage";
        }

        model.addAttribute(menu);
        return"menus/findMenu/name";
    }

    @GetMapping("/menus/findMenu/findMenuByPrice")
    public String findMenuByPrice(){
        return "/menus/findMenu/findMenuByPrice";
    }

    @PostMapping("/menus/findMenu/findMenuByPrice")
    public String menuFoundPrice(int price, Model model){
        List<Menu> list = menuService.findMenusByPrice(price);

        if(list == null){
            return "menus/error/notFoundMenuByPrice";
        }

        model.addAttribute(list);

        return"menus/findMenu/price";
    }

//    @GetMapping("/menus/errorPage")
//    public String errorPage(){
//        return "menus/error/errorPage";
//    }
}

//오류 고치기