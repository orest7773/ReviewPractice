interface Plateau extends Comparable<Plateau> {
  Plateau appendNextValue(int nextValue);

  int compareCountTo(int otherConsecutiveValueCount);
}