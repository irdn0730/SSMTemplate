package com.wn32.mapper;

import com.wn32.model.Student;
import java.util.List;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Jan 08 16:17:26 CST 2021
     */
    int deleteByPrimaryKey(Integer stuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Jan 08 16:17:26 CST 2021
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Jan 08 16:17:26 CST 2021
     */
    Student selectByPrimaryKey(Integer stuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Jan 08 16:17:26 CST 2021
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Fri Jan 08 16:17:26 CST 2021
     */
    int updateByPrimaryKey(Student record);
}