package com.dianrong.common.techops.action;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.PageDto;
import com.dianrong.common.uniauth.common.bean.dto.PermTypeDto;
import com.dianrong.common.uniauth.common.bean.dto.PermissionDto;
import com.dianrong.common.uniauth.common.bean.dto.RoleDto;
import com.dianrong.common.uniauth.common.bean.request.PermissionParam;
import com.dianrong.common.uniauth.common.bean.request.PermissionQuery;
import com.dianrong.common.uniauth.common.bean.request.RoleParam;
import com.dianrong.common.uniauth.sharerw.facade.UARWFacade;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Arc on 8/3/2016.
 */
@RestController
@RequestMapping("perm")
public class PermAction {

    @Resource
    private UARWFacade uARWFacade;

    @RequestMapping(value = "/query" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN') and ((principal.permMap['DOMAIN'] != null and principal.permMap['DOMAIN'].contains('techops')) or principal.domainIdSet.contains(#permissionQuery.domainId))")
    public Response<PageDto<PermissionDto>> searchPerm(@RequestBody PermissionQuery permissionQuery) {
        return uARWFacade.getPermissionRWResource().searchPerm(permissionQuery);
    }

    @RequestMapping(value = "/types" , method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<PermTypeDto>> getAllPermTypes() {
        return uARWFacade.getPermissionRWResource().getAllPermTypeCodes();
    }

    @RequestMapping(value = "/add" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN') and ((principal.permMap['DOMAIN'] != null and principal.permMap['DOMAIN'].contains('techops')) or principal.domainIdSet.contains(#permissionParam.domainId))")
    public Response<PermissionDto>  addNewPerm(@RequestBody PermissionParam permissionParam) {
        return uARWFacade.getPermissionRWResource().addNewPerm(permissionParam);
    }

    @RequestMapping(value = "/update" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN') and ((principal.permMap['DOMAIN'] != null and principal.permMap['DOMAIN'].contains('techops')) or principal.domainIdSet.contains(#permissionParam.domainId))")
    public Response<Void> updatePerm(@RequestBody PermissionParam permissionParam) {
        return uARWFacade.getPermissionRWResource().updatePerm(permissionParam);
    }

    @RequestMapping(value = "/replace-roles-to-perm" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN') and ((principal.permMap['DOMAIN'] != null and principal.permMap['DOMAIN'].contains('techops')) or principal.domainIdSet.contains(#permissionParam.domainId))")
    public Response<Void> replaceRolesToPerm(@RequestBody PermissionParam permissionParam) {
        return uARWFacade.getPermissionRWResource().replaceRolesToPerm(permissionParam);
    }

    @RequestMapping(value = "/all-roles-to-perm" , method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN') and ((principal.permMap['DOMAIN'] != null and principal.permMap['DOMAIN'].contains('techops')) or principal.domainIdSet.contains(#permissionParam.domainId))")
    public Response<List<RoleDto>> getAllRolesToPerm(@RequestBody PermissionParam permissionParam) {
        return uARWFacade.getPermissionRWResource().getAllRolesToPerm(permissionParam);
    }

}
