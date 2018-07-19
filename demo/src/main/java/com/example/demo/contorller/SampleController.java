package com.example.demo.contorller;



import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@Autowired
	private GirlProperties girlApplication;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		// return "Hello World!";
		return "id" + "-----" + id;
		// return girlApplication.getCupSize();
	}
}
