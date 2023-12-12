import arrays.Vetor;

public class App {
  public static void main(String[] args) {
        Vetor vetor = new Vetor(10);

        vetor.add("Item01");
        vetor.add("item02");

        vetor.add(1, "Novo item");

        System.out.println(vetor);
        
  }
}
