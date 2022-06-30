package study.encrypt;

import egovframework.rte.fdl.cryptography.EgovPasswordEncoder;
import org.junit.Test;


public class AriaDemoControllerTest {

  @Test
  public void hashGen(){
    EgovPasswordEncoder encoder = new EgovPasswordEncoder();
    encoder.setAlgorithm("SHA-256");
    System.out.println(encoder.encryptPassword("gwp!1234"));
  }

  @Test
  public void encryptTest(){


  }

}