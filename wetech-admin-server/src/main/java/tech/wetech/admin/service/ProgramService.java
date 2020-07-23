package tech.wetech.admin.service;

import tech.wetech.admin.model.dto.ProgramDTO;
import tech.wetech.admin.model.dto.ResDTO;
import tech.wetech.admin.model.entity.ProgramBaseInfo;
import tech.wetech.admin.model.entity.Role;

import java.util.List;


public interface ProgramService {

    void create(ProgramBaseInfo programBaseInfo);

    void updateNotNull(ProgramBaseInfo programBaseInfo);

    void deleteById(Long id);

    ResDTO programcreate(ProgramDTO programDTO);

    List getProgramInfoByMag(ProgramDTO programDTO);

    ResDTO getCurUserProgramInfo(Long id);
}
