package guava;

import com.google.common.base.*;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import study.dto.UserDto;

import java.util.ArrayList;

public class OptioanlTest {

  @Test
  public void 옵셔널되나(){

    String[] str = {null, "", "a"};

    for (String s : str) {
      System.out.println(s +"=>" + Optional.fromNullable(s).or("1"));
    }

    for (String s : str) {
      System.out.println(s +"=>" + Optional.fromNullable(s).get());
    }
  }

  @Test
  public void precondition(){

    String n = "null";

    String s = Preconditions.checkNotNull(n, "this %s is null", n);

    System.out.println(s);
  }

  @Test
  public void toStringTest(){
    System.out.println(new UserDto("최훈철", 44, UserDto.GENDER.MAN));
    System.out.println(new UserDto("최훈철", 44, null));
  }

  @Test
  public void compare(){
    UserDto 최훈철 = new UserDto("최훈철", 44, UserDto.GENDER.MAN);
    UserDto 문문 = new UserDto("문문", 27, UserDto.GENDER.WOMAN);
    UserDto 문문1 = new UserDto("문문1", 27, UserDto.GENDER.WOMAN);

    Assert.assertEquals(1, 최훈철.compareTo(문문));
    Assert.assertEquals(0, 문문.compareTo(문문));
    Assert.assertEquals(-1, 문문.compareTo(문문1));
  }

  @Test
 public void joiner(){
    System.out.println(Joiner.on(",").skipNulls()
        .join("최훈철", "" ,12, null, UserDto.GENDER.MAN ));
  }

  @Test
  public void splitter(){
    Iterable<String> split = Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,__b_ ,c__");

    for (String s : split) {
      System.out.println(s);
    }
  }

  @Test
  public void maps(){
    System.out.println(ImmutableMap.of("1", "할라랄", "2", "345", "3", null));
  }
  
  @Test
  public void functions(){
    ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

    String join = FluentIterable.from(integers).filter(new Predicate<Integer>() {
      @Override
      public boolean apply(@Nullable Integer integer) {
        return integer % 2 == 0;
      }
    }).transform(new Function<Integer, String>() {

      @Nullable
      @Override
      public String apply(@Nullable Integer integer) {
        return String.valueOf(integer) + "=even";
      }
    }).join(Joiner.on(","));

    System.out.println(join);
  }
}