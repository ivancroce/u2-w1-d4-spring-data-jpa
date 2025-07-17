package ictech.u2_w1_d4_spring_data_jpa.services;

import ictech.u2_w1_d4_spring_data_jpa.entities.MenuItem;
import ictech.u2_w1_d4_spring_data_jpa.exceptions.NotFoundException;
import ictech.u2_w1_d4_spring_data_jpa.repositories.MenuItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public void saveMenuItem(MenuItem item) {
        menuItemRepository.save(item);

        log.info("The item '" + item.getName() + "' it was saved successfully in the DB.");
    }

    public MenuItem findMenuItemById(long id) {
		/*Optional<User> foundOrNot = usersRepository.findById(userId);
		if (foundOrNot.isPresent()) return foundOrNot.get();
		else throw new NotFoundException(userId);*/
        return menuItemRepository.findById(id).orElseThrow(() -> new NotFoundException(id)); // Alternativa più compatta al codice di sopra
    }
    
}
