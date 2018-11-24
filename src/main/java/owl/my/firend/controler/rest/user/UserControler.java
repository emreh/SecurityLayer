package owl.my.firend.controler.rest.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/user")
public class UserControler {

	private static final String ERROR_PAGE_403 = "redirect:/error/403.jsp";

	private Subject subject = SecurityUtils.getSubject();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ModelAndView login(@PathVariable("username") String userName, @PathVariable("password") String password) {
		ModelAndView modelAndView = new ModelAndView();
		if (userName != null && !userName.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			try {
				// subject.getSubject().login(token);
				subject.login(token);
				modelAndView.setViewName("user/admin/admin");
			} catch (Exception e) {
				e.printStackTrace();
				modelAndView.setViewName(ERROR_PAGE_403);
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logoutSuccessfulPage(HttpServletRequest request, HttpServletResponse response) {

		logout();

		ModelAndView model = new ModelAndView();
		model.setViewName("alterPage/logoutSuccessfulPage");

		return model;
	}

	public void logout() {
		SecurityUtils.getSubject().logout();
	}
}