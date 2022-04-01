package personservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personservice.model.ListEntity;
import personservice.repository.ListRepository;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepository listRepository;

    @Override
    public List<ListEntity> getAll() {
        return listRepository.getAll();
    }

    @Override
    public ListEntity getById(Long listId) {
        return listRepository.getById(listId);
    }

    @Override
    public Long getIdByNumber(Long listNumber) {
        return listRepository.getIdByNumber(listNumber);
    }

    @Override
    public List<ListEntity> getAllByNumber(Long number) {
        return listRepository.getAllByNumber(number);
    }

    @Override
    public int insertAll(List<ListEntity> list) {
        return listRepository.insertAll(list);
    }
}
