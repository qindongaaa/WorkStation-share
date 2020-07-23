package tech.wetech.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tech.wetech.admin.mapper.ProgramMapper;
import tech.wetech.admin.model.dto.ProgramDTO;
import tech.wetech.admin.model.dto.ResDTO;
import tech.wetech.admin.model.entity.ProgramBaseInfo;


import tech.wetech.admin.service.ProgramService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static tech.wetech.admin.utils.DateUtil.toDateTimeString;


@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramMapper programMapper;

    @Override
    public void create(ProgramBaseInfo programBaseInfo) {
        programMapper.insertSelective(programBaseInfo);
    }

    @Override
    public void updateNotNull(ProgramBaseInfo programBaseInfo) {
        programMapper.updateByPrimaryKeySelective(programBaseInfo);
    }

    @Override
    public void deleteById(Long id) {
        programMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ResDTO programcreate(ProgramDTO programDTO) {
        ProgramBaseInfo program = programMapper.selectByProgramname(programDTO.getProgramname());
        ResDTO res = new ResDTO();
        java.sql.Date time= new java.sql.Date(new Date().getTime());
        if(program == null){
            program = new ProgramBaseInfo();
            program.setProgramname(programDTO.getProgramname());
            program.setProgrambrief(programDTO.getProgrambrief());
            program.setProgrammag(programDTO.getProgrammag());
            program.setProgramquota(programDTO.getProgramquota());
            program.setProgramduration(programDTO.getProgramduration());
            program.setStarttime(programDTO.getProgramstarttime());
            program.setCreatetime(time);
            program.setCreaterid(programDTO.getCreaterid());
            programMapper.insertSelective(program);
            res.setState(1);
            res.setValue("success");
        } else{
            res.setState(0);
            res.setValue("fail");
        }
        return res;
    }

    @Override
    public List getProgramInfoByMag(ProgramDTO programDTO) {
        List<ProgramBaseInfo> program = programMapper.selectByCreaterid(programDTO.getCreaterid());
        return program;
    }

    @Override
    public ResDTO getCurUserProgramInfo(Long id) {
        JSONArray array = new JSONArray();
        List<ProgramBaseInfo> program = programMapper.selectByCreaterid(id);
        for(ProgramBaseInfo p:program){
            JSONObject obj = new JSONObject();
            obj.put("programname",p.getProgramname());
            obj.put("programbrief",p.getProgrambrief());
            obj.put("programduration",p.getProgramduration());
            obj.put("programquota",p.getProgramquota());
            obj.put("programstarttime",toDateTimeString(p.getStarttime()));
            obj.put("programmag",p.getProgrammag());
            array.add(obj);
        }
        ResDTO res = new ResDTO();
        res.setObject(array);
        res.setState(1);
        return res;
    }
}
