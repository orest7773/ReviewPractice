public class Main {

  public static void main(String[] args) throws WrongNumberOfGuestsException {
    RumorCalculation rCalc = new RumorCalculation(8);
    System.out.println("The probability of all guest hearing rumor: " + rCalc.getProbability());
    rCalc.getEstimationGuestRumor();
  }
}
