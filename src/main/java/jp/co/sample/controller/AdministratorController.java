package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;
/**
 * controller 作成。
 * setUp,insertのみ作成済み。
 * @author hiratanagahiro
 *
 */


@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
		return insertAdministratorForm;
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		
		return "administrator/insert.html";
	}
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
//		Administrator administrator = new Administrator();
//		administrator.setId(form.ge);
	}
	
	
}
