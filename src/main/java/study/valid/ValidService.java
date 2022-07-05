package study.valid;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.validation.*;
import study.dto.UserDto;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ValidService {

  @Resource
  private Validator validator;

  public List<UserDto> valid(){

    List<UserDto> userDtos = Lists.newArrayList(
        new UserDto("", 43, UserDto.GENDER.MAN)
        , new UserDto("이", 43, UserDto.GENDER.MAN)
        , new UserDto("", 423, UserDto.GENDER.MAN)
    );

    for (UserDto userDto : userDtos) {
      BeanPropertyBindingResult result = new BeanPropertyBindingResult(userDtos, "userDto");
      validator.validate(userDto, result);
      System.out.println(userDto + ":" + result);
    }

    return userDtos;
  }
}
