package us.nm.state.hsd.diceware.service;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DicewareGenerator implements PassphraseGenerator {

  private final Random rng;
  public DicewareGenerator(Random rng, WordProvider provider) {
    this.rng = rng;
    words = new ArrayList<String>(provider.words());
  }

  private final List<String> words;
  
  @Override
  public String[] generate(int length) {
    String[] passphrase = new String[length];
    for(int i = 0; i < length; i++) {
      String word = words.get(rng.nextInt(words.size()));
      passphrase[i] = word; 
    }
    return passphrase;
  }

}
