package study.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.jetbrains.annotations.NotNull;

public class UserDto implements Comparable<UserDto>{

  private String name;
  private int age;
  private GENDER gender;

  public UserDto(String name, int age, GENDER gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public GENDER getGender() {
    return gender;
  }

  public void setGender(GENDER gender) {
    this.gender = gender;
  }

  public enum GENDER{
    MAN(1), WOMAN(2);

    private int code;

    GENDER(int code) {
      this.code = code;
    }

    public int code() {
      return code;
    }
  }

  @Override
  public int compareTo(@NotNull UserDto o) {
    return ComparisonChain.start()
        .compare(this.age, o.age)
        .compare(this.name, o.name)
        .result();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("name", name)
        .add("age", age)
        .add("gender", gender)
        .toString();
  }
}
