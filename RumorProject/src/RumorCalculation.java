public class RumorCalculation {

  private int numberOfGuest;

  public RumorCalculation(int numberOfGuest) throws WrongNumberOfGuestsException {
    this.numberOfGuest = numberOfGuest;
    //wrong input
    if (numberOfGuest < 1) {
      throw new WrongNumberOfGuestsException();
    }
    System.out.println("The rumor has gone!");
  }

  public double getProbability() {
    return calcOfProbability(this.numberOfGuest);
  }

  //private function to calculate probabilty of N guest hearing rumor
  private double calcOfProbability(int numberOfGuest) {
    double probability = 1.0;
    for (int counter = 1; counter <= numberOfGuest - 1; counter++) {
      probability *= (double) ((numberOfGuest - counter + 1)) / (numberOfGuest);
    }
    return probability;
  }

  //function that outputs all the probabilties of n,n-1,...1 guests hearing the rumor
  public void getEstimationGuestRumor() {
    for (int counter = 2; counter <= numberOfGuest; counter++) {
      System.out.println(
          "Probability of " + counter + " guest hearing the rumor: " + calcOfProbability(counter));
    }
  }
}


