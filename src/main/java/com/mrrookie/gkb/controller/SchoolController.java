package com.mrrookie.gkb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mrrookie.gkb.common.ApiCode;
import com.mrrookie.gkb.common.Result;
import com.mrrookie.gkb.common.Results;
import com.mrrookie.gkb.form.AddSchoolForm;
import com.mrrookie.gkb.form.UpdateSchoolForm;
import com.mrrookie.gkb.mapper.SchoolMapper;
import com.mrrookie.gkb.model.School;
import com.mrrookie.gkb.model.SchoolConvert;
import com.mrrookie.gkb.vo.SchoolVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PengchengWang
 * @className com.mrrookie.practicespringbootlog.controller.UserController
 * @createDate 2020/7/24 10:58
 */
@Api(tags = {"学校管理服务"})
@AllArgsConstructor
@RestController()
public class SchoolController {
    private final SchoolMapper schoolMapper;
    private final SchoolConvert schoolConvert;

    @ApiOperation(value = "添加学校信息")
    @PostMapping(value = "/schools")
    public Result addSchool(@RequestBody AddSchoolForm form) {
        School school = schoolConvert.fromAddSchoolForm(form);
        LocalDateTime now = LocalDateTime.now();
        school.setCreatedTime(now);
        school.setUpdatedTime(now);
        int rows = schoolMapper.insert(school);
        if (rows <= 0) {
            return Results.failure(ApiCode.SAVE_FAILURE);
        }
        return Results.success();
    }

    @ApiOperation(value = "分页获取学校列表")
    @GetMapping(value = "/schools")
    public Result<IPage<SchoolVo>> listSchool(@ApiParam(name = "pageNo") @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
                                              @ApiParam(name = "pageSize") @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize) {
        IPage<School> schoolIPage = new Page<>(pageNo, pageSize);
        schoolMapper.selectPage(schoolIPage, null);
        List<SchoolVo> schoolVos = schoolIPage.getRecords().stream().map(school -> schoolConvert.toSchoolVo(school)).collect(Collectors.toList());

        IPage<SchoolVo> schoolVoIPage = new Page<>();
        schoolVoIPage.setCurrent(schoolIPage.getCurrent());
        schoolVoIPage.setPages(schoolIPage.getPages());
        schoolVoIPage.setSize(schoolIPage.getSize());
        schoolVoIPage.setTotal(schoolIPage.getTotal());
        schoolVoIPage.setRecords(schoolVos);

        return Results.success(schoolVoIPage);
    }

    @ApiOperation(value = "根据学校ID删除学校信息")
    @DeleteMapping(value = "/schools/{schoolId}")
    public Result deleteSchool(@ApiParam(value = "schoolId") @PathVariable(name = "schoolId") Long schoolId) {
        int rows = schoolMapper.deleteById(schoolId);
        if (rows <= 0) {
            return Results.failure(ApiCode.DELETE_FAILURE);
        }
        return Results.success();
    }

    @ApiOperation(value = "根据学校ID获取学校信息")
    @GetMapping(value = "/schools/{schoolId}")
    public Result<SchoolVo> detailSchool(@ApiParam(value = "schoolId") @PathVariable(name = "schoolId") Long schoolId) {

        School school = schoolMapper.selectById(schoolId);
        if (school == null) {
            return Results.failure(ApiCode.DATA_NOT_EXIST, null);
        }
        SchoolVo schoolVo = schoolConvert.toSchoolVo(school);
        return Results.success(schoolVo);
    }

    @ApiOperation(value = "根据学校ID更新学校信息")
    @PutMapping(value = "/schools/{schoolId}")
    public Result updateSchool(@ApiParam(value = "schoolId") @PathVariable(name = "schoolId") Long schoolId,
                               @RequestBody UpdateSchoolForm form) {
        // 查询学校是否存在
        School school = schoolMapper.selectById(schoolId);
        if (school == null) {
            return Results.failure(ApiCode.DATA_NOT_EXIST);
        }

        school = schoolConvert.fromUpdateSchoolForm(form);
        school.setId(schoolId);
        school.setUpdatedTime(LocalDateTime.now());
        int rows = schoolMapper.updateById(school);
        if (rows <= 0) {
            return Results.failure(ApiCode.UPDATE_FAILURE);
        }
        return Results.success();
    }
}
