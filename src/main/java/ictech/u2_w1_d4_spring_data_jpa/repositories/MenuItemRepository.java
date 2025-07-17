package ictech.u2_w1_d4_spring_data_jpa.repositories;

import ictech.u2_w1_d4_spring_data_jpa.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Derived Queries
    List<MenuItem> findByName(String name); // SELECT * FROM menu_items WHERE name = :name

    List<MenuItem> findByCaloriesGreaterThan(int caloriesNumber); // SELECT * FROM menu_items WHERE calories > :caloriesNumber
}
