package personservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import personservice.dto.ListDto;
import personservice.mapper.ListMapper;
import personservice.model.ListEntity;
import personservice.service.ListServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Validated
@RequestMapping("/list")
public class ListController {

    ListServiceImpl listServiceImpl;
    ListMapper listMapper;

    public ListController(ListServiceImpl listServiceImpl, ListMapper listMapper) {
        this.listServiceImpl = listServiceImpl;
        this.listMapper = listMapper;
    }

    @GetMapping("/")
    List<ListEntity> findAll (){
        return listServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    ListEntity findById (@PathVariable Long id){
        return listServiceImpl.getById(id);
    }

    /**
     * Список сохраняется в БД, ему присваивается уникальный номер, основанный на текущем времени Date
     *
     * @param listDto - с фронта заполняется список необходимых товаров
     * @return - ответ ОК
     */
    @PostMapping("/save")
    ResponseEntity<List<ListDto>> saveList (@RequestBody List<ListDto> listDto){
        List<ListEntity> listEntities = new ArrayList<>();
        Date date = new Date();

        listDto.forEach(l -> listEntities.add(listMapper.toEntity(l)));
        listEntities.forEach(l -> l.setNumber(date.getTime()));
        listServiceImpl.insertAll(listEntities);

        return ResponseEntity.ok(listDto);
    }
}
