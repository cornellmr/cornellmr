package us.nm.state.hsd.diceware.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.nm.state.hsd.diceware.service.PassphraseGenerator;

@Controller
@RequestMapping("/diceware")
public class SimpleDicewareController {

  private final PassphraseGenerator generator;
  
  @Autowired
  public SimpleDicewareController(PassphraseGenerator generator) {
    this.generator = generator;
  }
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String[] get(@RequestParam(required=false, defaultValue = "4") int length) {
    return generator.generate(length);
  }
  
  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String get(@RequestParam(required=false, defaultValue = "4") int length, Model Model) {
    Model.addAttribute("words",generator.generate(length));
    return "passphrase";
  }
    
}
