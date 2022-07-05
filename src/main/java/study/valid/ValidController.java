package study.valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import study.dto.UserDto;

import javax.annotation.Resource;
import javax.validation.Valid;


@Controller
public class ValidController {

  @Resource
  private Validator validator;

  @Autowired
  private ValidService validService;

  @InitBinder
  public void initBinder(WebDataBinder dataBinder){
    dataBinder.setValidator(validator);
  }

  @RequestMapping(value = "/study/valid.do")
  public String valid(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult){

    System.out.println(bindingResult);

    return "study/valid/valid_demo";
  }

  @RequestMapping(value = "/study/valid2.do")
  public String valid(){

    validService.valid();

    return "study/valid/valid_demo";
  }
}
