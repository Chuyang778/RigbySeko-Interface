package com.rigby.api.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rigby.apicommon.model.entity.Auth;
import org.apache.ibatis.annotations.Mapper;

/**
* @author WZY
* @description 针对表【auth】的数据库操作Mapper
* @createDate 2023-01-17 10:33:59
* @Entity generator.domain.Auth
*/
@Mapper
public interface AuthMapper extends BaseMapper<Auth> {

}




