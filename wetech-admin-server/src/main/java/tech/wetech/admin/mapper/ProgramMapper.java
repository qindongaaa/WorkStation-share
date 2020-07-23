package tech.wetech.admin.mapper;

import tech.wetech.admin.model.entity.ProgramBaseInfo;

import tech.wetech.mybatis.mapper.BaseMapper;

import java.util.List;

public interface ProgramMapper extends BaseMapper<ProgramBaseInfo> {

    default ProgramBaseInfo selectByProgramname(String programname) {
        return this.createCriteria().andEqualTo(ProgramBaseInfo::getProgramname, programname).selectOne();
    }

    default List<ProgramBaseInfo> selectByCreaterid(Long createid) {
        return this.createCriteria().andEqualTo(ProgramBaseInfo::getCreaterid, createid).selectList();
    }
}
