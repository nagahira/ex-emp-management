package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;
/**
 * EmployeeRepository 
 * employeesテーブルへのfindAll(),load(),update()
 * 
 * @author hiratanagahiro
 *
 */


@Repository
public class EmployeeRepository {
	
private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

@Autowired
private NamedParameterJdbcTemplate template;

public List<Employee> findAll(){
	String sql ="SELECT id,name,image,gender,hire_date,mail_address,zip_code,address"
			+ " ,telephone,salary,characteristics,dependents_count FROM employees ORDER BY age;";
	
	List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
	
	if(employeeList == null) {
		return null;
	}else {
	return employeeList;
	}
	
}

public Employee load(Integer id) {
	String sql ="SELECT id,name,image,gender,hire_date,mail_address,zip_code,address"
			+ " ,telephone,salary,characteristics,dependents_count FROM employees WHERE id=:id";
	
	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
	
	Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
	
	return employee;
}

public void update(Employee employee) {
	String sql ="UPDATE employees SET name=:name,image=:image,gender=:gender,hire_date=:hireDate,mail_address=:mailAddress,zip_code=:zipCode,address"
			+ " ,telephone=:telephone,salary=:salary,characteristics=:characteristics,dependents_count=:dependentsCountdepe FROM employees WHERE id=:id";
	
	SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
	
	template.update(sql, param);
}

	
	
}
