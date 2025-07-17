package ictech.u2_w1_d4_spring_data_jpa.runners;

import ictech.u2_w1_d4_spring_data_jpa.entities.Pizza;
import ictech.u2_w1_d4_spring_data_jpa.entities.Topping;
import ictech.u2_w1_d4_spring_data_jpa.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired
    private MenuItemService menuItemService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Saving Data ---");

        // TOPPINGS
        Topping tomato = new Topping("Tomato Sauce", 0, 0.00);
        Topping cheese = new Topping("Cheese", 92, 0.69);
        Topping ham = new Topping("Ham", 35, 0.99);
        Topping onions = new Topping("Onions", 22, 0.69);
        Topping forbiddenWord = new Topping("Pineapple", 24, 0.79);
        Topping salami = new Topping("Salami", 86, 0.99);
        // menuItemService.saveMenuItem(tomato);
        /*menuItemService.saveMenuItem(cheese);
        menuItemService.saveMenuItem(ham);
        menuItemService.saveMenuItem(onions);
        menuItemService.saveMenuItem(forbiddenWord);
        menuItemService.saveMenuItem(salami);*/

        // Toppings from db
        Topping tomatoFromDb = (Topping) menuItemService.findMenuItemById(1);
        Topping cheeseFromDb = (Topping) menuItemService.findMenuItemById(2);

        // PIZZAS
        Pizza margherita = new Pizza("Pizza Margherita", 1104, 4.99, List.of(tomatoFromDb, cheeseFromDb));
        // menuItemService.saveMenuItem(margherita);

        //to continue
        
        // DRINKS
    }
}
