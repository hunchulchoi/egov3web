package study.encrypt.service;

import egovframework.rte.fdl.cryptography.EgovCryptoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class AriaServiceImpl {

  @Resource(name = "ARIACryptoService")
  private EgovCryptoService cryptoService;

  private String password = "gwp!1234";

  public String ariaEncrypt(String plainText){

    return new String(cryptoService.encrypt(plainText.getBytes(StandardCharsets.UTF_8), password), StandardCharsets.UTF_8);
  }
}
