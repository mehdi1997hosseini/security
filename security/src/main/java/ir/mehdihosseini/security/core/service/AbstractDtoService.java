package ir.mehdihosseini.security.core.service;

import ir.mehdihosseini.security.core.service.dto.BasicDtoService;

import java.util.List;

public abstract class AbstractDtoService<DTO> implements BasicDtoService<DTO> {

    @Override
    public DTO save(DTO dto) {
        return null;
    }

    @Override
    public List<DTO> saveList(List<DTO> listDto) {
        return List.of();
    }

    @Override
    public List<DTO> findAll() {
        return List.of();
    }
}
