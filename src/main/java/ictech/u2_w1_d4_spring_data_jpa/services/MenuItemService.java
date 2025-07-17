package ictech.u2_w1_d4_spring_data_jpa.services;

import ictech.u2_w1_d4_spring_data_jpa.entities.MenuItem;
import ictech.u2_w1_d4_spring_data_jpa.exceptions.NotFoundException;
import ictech.u2_w1_d4_spring_data_jpa.repositories.MenuItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public void saveMenuItem(MenuItem item) {
        menuItemRepository.save(item);

        log.info("The item '" + item.getName() + "' was saved successfully in the DB.");
    }

    public MenuItem findMenuItemById(long id) {
		/*Optional<User> foundOrNot = usersRepository.findById(userId);
		if (foundOrNot.isPresent()) return foundOrNot.get();
		else throw new NotFoundException(userId);*/
        return menuItemRepository.findById(id).orElseThrow(() -> new NotFoundException(id)); // alternative
    }

    public void findMenuItemByIdAndUpdate(long id, MenuItem updatedMenuItem) {
        MenuItem found = this.findMenuItemById(id);

        found.setName(updatedMenuItem.getName());
        found.setCalories(updatedMenuItem.getCalories());
        found.setPrice(updatedMenuItem.getPrice());

        menuItemRepository.save(found);
        log.info("The item with ID'" + id + "' was updated successfully in the DB.");
    }

    public void findMenuItemByIdAndDelete(long id) {
        MenuItem found = this.findMenuItemById(id);

        menuItemRepository.delete(found);
        log.info("The item with ID'" + id + "' was deleted successfully in the DB.");
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    // Using derived queries from repository
    public List<MenuItem> findMenuItemsByName(String name) {
        return menuItemRepository.findByName(name);
    }

    public List<MenuItem> findItemsWithMoreCaloriesThan(int cal) {
        return menuItemRepository.findByCaloriesGreaterThan(cal);
    }

}
