package jp.co.sample.form;
/**
 * InsertAdministratorForm
 * 名前、メールアドレス、パスワード入力。
 * @author hiratanagahiro
 *
 */


public class InsertAdministratorForm {
private String name;
private String mailAddress;
private String password;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMailAddress() {
	return mailAddress;
}
public void setMailAddress(String mailAddress) {
	this.mailAddress = mailAddress;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
}
	
}