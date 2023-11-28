package qpassessment.Service;

import org.springframework.stereotype.Service;
import qpassessment.Exception.ResourceNotFoundException;
import qpassessment.Model.Item;
import qpassessment.Respository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> listAllItems(){
        return repository.findAll();
    }

    public List<Item> listAllAvailableItems(){
        return repository.findAllItems();
    }

    public Item listItemById(Integer id){
        Optional<Item> option =  repository.findById(id);
        if(option.isEmpty())
            throw new ResourceNotFoundException("Item "+id+" not found");
        return option.get();
    }

    public Item addNewItem(Item item){
        return repository.save(item);
    }

    public Item updateItem(Item item){
        Item repoItem = listItemById(item.getId());
        if(item.getName()!=null)
            repoItem.setName(item.getName());
        if(item.getInventory()!=null)
            repoItem.setInventory(item.getInventory());
        if(item.getPrice()!=null)
            repoItem.setPrice(item.getPrice());
        return repository.save(repoItem);
    }

    public void deleteItem(Integer id){
         repository.deleteById(id);
    }
}
