package owl.my.firend.controler.rest.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spa")
public class JWTProvider {

	@RequestMapping(value = "/getValue", method = RequestMethod.POST)
	public String getValue() {
		return "OK";
	}
}