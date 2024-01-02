import java.util.Scanner;

public class GuessNumberGame {
  public static void main(String[] args) {
    int number = (int) (Math.random() * 100 + 1);
    Scanner input = new Scanner(System.in);
    System.out.println("Adivinhe o número entre 1 e 100:");

    for (int i = 0; i < 7; i++) {
      System.out.print("Insira seu palpite: ");
      int guess = input.nextInt();

      if (guess == number) {
        System.out.println("Parabéns, você adivinhou o número!");
        return;
      } else if (guess < number) {
        System.out.println("Seu palpite está abaixo.");
      } else {
        System.out.println("Seu palpite está acima.");
      }
    }

    System.out.println("Você perdeu. O número era " + number + ".");
  }
}