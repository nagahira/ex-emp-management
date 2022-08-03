package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * コントローラー インサート作成
 * 
 * @author hiratanagahiro
 *
 *
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private HttpSession session;
	
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
		Administrator administrator = new Administrator();
		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
		administratorService.insert(administrator);
//
//		administrator.setName("ああああ");
//		administrator.setMailAddress("aaaaaa");
//		administrator.setPassword("aaaaaa");
//		administratorService.insert(administrator);
		return "redirect:/";
	}

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	
	
	@RequestMapping("/")
		public String toLogin() {
		return "administrator/login.html";
	}
	
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		
		if(administrator == null) {
			model.addAttribute("message","メールアドレスまたはパスワードが不正です。");
			return "administrator/login";
		}else {
			session.setAttribute("administrayorName", administrator);
			return "forward:/employee/showList";
		}
	}

}
