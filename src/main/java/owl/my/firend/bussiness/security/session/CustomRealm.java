package owl.my.firend.bussiness.security.session;

import java.util.List;

import javax.ejb.EJB;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import owl.my.firend.controler.ejb.interfaces.user.UserActionRemote;
import owl.my.firend.persistence.model.user.UserDetails;
import owl.my.firend.persistence.model.user.UserPermission;
import owl.my.firend.persistence.model.user.UserRole;

@Service
public class CustomRealm extends AuthorizingRealm {

	@EJB(name = "userloginBean")
	private UserActionRemote userActionBean;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		// identify account to log to
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String username = userPassToken.getUsername();
		if (username == null)
			return null;
		try {
			final UserDetails user = userActionBean.findUser(username);
			if (user == null)
				return null;
			else if (!user.isEnable())
				return null;

			// return salted credentials
			SaltedAuthenticationInfo info = new SaltedAuthentificationInfo(username, user.getPassword(),
					user.getSalt());
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
			throws AuthenticationException {
		checkNotNull(principalCollection, "PrincipalCollection method argument cannot be null.");
		String username = (String) principalCollection.getPrimaryPrincipal();
		UserDetails user = userActionBean.findUser(username);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		List<UserRole> roles = user.getUserRoleList();
		roles.forEach(role -> info.addRole(role.getRoleName().getUserRoleDefineValue()));

		List<UserPermission> permissionList = user.getUserPermissions();
		permissionList.forEach(perm -> info.addStringPermission(perm.getPermission()));

		return info;
	}

	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}