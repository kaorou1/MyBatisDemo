package com.kaorou.mybatis.mapper;

import com.kaorou.mybatis.entity.QueryVo;
import com.kaorou.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    /*
    只写接口，四个原则
    1. 方法名和Mapper.xml中的id一致
    2. 返回值类型和Mapper.xml中的resultType一致
    3. 传入参数和Mapper.xml中的parameterType一致
    4. mapper接口类的全路径与Mapper.xml的命名空间一致
    */

//    /**
//     * 通过Id查询用户
//     * @param id
//     * @return
//     */
//    User selectUserById(Integer id);
//
//    /**
//     * 通过名称模糊查询用户
//     * @param name
//     * @return
//     */
//    List<User> selectUserByName(String name);
//
//    /**
//     * 添加用户
//     * @param user
//     */
//    void insertUser(User user);
//
//    /**
//     * 根据ID更新用户
//     * @param user
//     */
//    void updateUserById(User user);
//
//    /**
//     * 根据ID删除用户
//     * @param id
//     */
//    void deleteUserById(Integer id);

    /**
     * 通过包装类模糊查询
     * @param vo
     * @return
     */
    List<User> selectUserByQueryVo(QueryVo vo);

    /**
     * 查询所有记录条数
     * @return
     */
    Integer countAll();

    /**
     * 根据性别和名字查询用户
     * @param user
     * @return
     */
    List<User> selectUserBySexAndUsername(User user);

    /**
     * 根据多个id查询用户 in(1, 2, 3)
     */
    List<User> selectUserByIdArray(Integer[] ids);
    List<User> selectUserByIdList(List<Integer> list);
    List<User> selectUserByIds(QueryVo vo);

}
