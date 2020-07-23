package tech.wetech.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import tech.wetech.admin.model.Result;
import tech.wetech.admin.model.dto.ProgramDTO;
import tech.wetech.admin.model.dto.ResDTO;
import tech.wetech.admin.service.ProgramService;
import tech.wetech.admin.service.UserService;
import tech.wetech.admin.utils.Oauth2Util;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@RestController
public class ProgramController {

    @Autowired
    private ProgramService programService;
    @Autowired
    private UserService userService;

    @PostMapping("program/getPorgramInfoByCreaterid")
    public List getProgramInfoByMag(@RequestBody ProgramDTO programDTO) {
        List programlist = programService.getProgramInfoByMag(programDTO);
        return programlist;
    }

    @PostMapping("program/create")
    public Result<ResDTO> programcreate(@RequestBody ProgramDTO programDTO,HttpServletRequest request) {
        Oauth2Util Oauth = new Oauth2Util();
        String userJwt = Oauth.getJwtClaimsFromHeader(request);
        Long userId = userService.queryByUsername(userJwt).getId();
        programDTO.setCreaterid(userId);
        ResDTO  res = programService.programcreate(programDTO);
        return Result.success(res);
    }

    @PostMapping("program/getCurUserPorgramInfo")
    public Result<ResDTO> getCurUserProgramInfo(HttpServletRequest request) {
        Oauth2Util Oauth = new Oauth2Util();
        String userJwt = Oauth.getJwtClaimsFromHeader(request);
        Long userId = userService.queryByUsername(userJwt).getId();
        ResDTO  res = programService.getCurUserProgramInfo(userId);
        return Result.success(res);
    }
}
