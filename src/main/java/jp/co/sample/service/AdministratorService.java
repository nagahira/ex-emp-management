package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	public  void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
		
		
	}
	
	/**
	 * @author hiratanagahiro
	 * @param mailAddress
	 * @param password
	 * @return
	 * ログイン処理。mailaddress,passwordをreturn
	 */
	
	
	//下使うログイン
	public Administrator login(String mailAddress,String password) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, password);
		return administrator;
	}
	
}
