package qpassessment.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import qpassessment.Model.Item;
import qpassessment.Service.ItemService;

import java.net.URI;
import java.util.List;

@RestController("/admin")
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/item")
    public List<Item> get(){
        return service.listAllItems();
    }

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable Integer id){
        return service.listItemById(id);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> addNewItem(@RequestBody Item item){
        Item s_item =  service.addNewItem(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(s_item.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("/item")
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        Item s_item =  service.updateItem(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(s_item.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable Integer id){
        service.deleteItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/item")
    public List<Item> getAvailableItems(){
        return service.listAllAvailableItems();
    }




}
