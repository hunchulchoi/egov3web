package study.encrypt;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.encrypt.service.AriaServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class AriaDemoController {

	private final Logger logger = getLogger(this.getClass());

	private AriaServiceImpl ariaService;

	@Autowired
	public void setAriaService(AriaServiceImpl ariaService) {
		this.ariaService = ariaService;
	}

	@RequestMapping("/study/aria.do")
	public String aria(){

		logger.debug("Hello({})", "할로");
		
		return "study/encrypt/aria_demo";
	}

	@RequestMapping(value = "/study/aria_encrypt.do", method = RequestMethod.POST)
	@ResponseBody
	public String ariaEncrypt(@RequestParam String plainText){

		final String encryptedText = ariaService.ariaEncrypt(plainText);

    return encryptedText;//ImmutableMap.of("encryptedText", encryptedText);
	}
}
