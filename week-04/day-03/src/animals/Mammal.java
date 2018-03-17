package animals;

public class Mammal extends Animal {

  public Mammal(String name) {
    super(name);
  }

  @Override
  public String getName() {
    return super.name;
  }

  @Override
  public String breed() {
    return "pushing miniature versions out.";
  }
}
