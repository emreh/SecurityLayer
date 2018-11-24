package owl.my.firend.controler.ejb.interfaces.user;

import owl.my.firend.persistence.model.user.UserDetails;

public interface LoginBeanRemote {
	public UserDetails login(String userName, String password);

	public void logOut(String userName);
}