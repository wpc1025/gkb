package com.mrrookie.gkb.model;

import com.mrrookie.gkb.form.AddSchoolForm;
import com.mrrookie.gkb.form.UpdateSchoolForm;
import com.mrrookie.gkb.vo.SchoolVo;
import org.mapstruct.Mapper;

/**
 * @author PengchengWang
 * @className com.mrrookie.gkb.model.SchoolMapStructMapper
 * @createDate 2020/7/28 10:28
 */
@Mapper(componentModel = "spring")
public interface SchoolConvert {

    School fromAddSchoolForm(AddSchoolForm form);

    School fromUpdateSchoolForm(UpdateSchoolForm form);

    SchoolVo toSchoolVo(School school);
}
