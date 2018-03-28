import java.util.HashSet;
import java.util.Set;

public class LargestPlateau {
  private static final String LONGEST_PLATEAU_IS = "longest Plateau is: %s";
  private static final int SKIP_FIRST_VALUE = 1;
  public static void main(String[] args) {
    LargestPlateau largestPlateau = new LargestPlateau();
    System.out.println(String.format(LONGEST_PLATEAU_IS, largestPlateau.findLongestPlateauIn(new int[] { 1, 2, 3, 3, 3, 1 })));
    System.out.println(String.format(LONGEST_PLATEAU_IS, largestPlateau.findLongestPlateauIn(new int[] {  1, 2, 3, 3, 3, 4, 5, 5, 4})));
    System.out.println(String.format(LONGEST_PLATEAU_IS, largestPlateau.findLongestPlateauIn(new int[] { 1, 2, 3, 3, 3, 2, 5, 5, 4 })));
  }


  public Plateau findLongestPlateauIn(int[] valueList) {
    Set<Plateau> plateaus = findAllPlateaus(valueList);
    return selectLongestPlateau(plateaus);
  }

  private Plateau selectLongestPlateau(Set<Plateau> plataeus) {
    Plateau longestPlataeu = plataeus.stream().max((p1, p2) -> p1.compareTo(p2)).get();
    return longestPlataeu;
  }

  private Set<Plateau> findAllPlateaus(int[] valueList) {
    Set<Plateau> plateaus = new HashSet<>();
    Plateau currentPlateau = new RealPlateau(0, valueList[0]);
    plateaus.add(currentPlateau);
    for (int i = SKIP_FIRST_VALUE; i < valueList.length; i++) {
      Plateau nextPlateau = currentPlateau.appendNextValue(valueList[i]);
      if (currentPlateau != nextPlateau) {
        plateaus.add(nextPlateau);
        currentPlateau = nextPlateau;
      }
    }
    return plateaus;
  }
}