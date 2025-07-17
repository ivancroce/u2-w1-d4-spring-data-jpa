package ictech.u2_w1_d4_spring_data_jpa.repositories;

import ictech.u2_w1_d4_spring_data_jpa.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
