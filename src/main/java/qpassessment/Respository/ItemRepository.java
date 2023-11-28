package qpassessment.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qpassessment.Model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    @Query("SELECT i FROM Item i WHERE i.inventory>0")
    List<Item> findAllItems();
}
