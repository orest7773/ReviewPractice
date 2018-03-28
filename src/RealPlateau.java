class RealPlateau implements Plateau {
  private int startIndex;
  private int value;
  private int consecutiveValueCount = 0;
  public RealPlateau(int startIndex, int value) {
    this.startIndex = startIndex;
    this.value = value;
  }

  @Override
  public Plateau appendNextValue(int nextValue) {
    if (this.value == nextValue) {
      consecutiveValueCount++; // enlarge the current plateau
      return this;
    }
    if (this.value > nextValue) { // found end of a real Plateau
      return new NonPlateau(startIndex + (++consecutiveValueCount), value); // nextValue cannot be start of a plateau.
    }
    // a new plateau might start here, so reset state
    startIndex += ++consecutiveValueCount;
    this.value = nextValue;
    consecutiveValueCount = 0;
    return this;
  }
  @Override
  public int compareTo(Plateau o) {
    return o.compareCountTo(consecutiveValueCount);
  }
  @Override
  public int compareCountTo(int otherConsecutiveValueCount) {
    return otherConsecutiveValueCount - consecutiveValueCount;
  }
  @Override
  public String toString() {
    return "RealPlataeu [startIndex=" + startIndex + ", value=" + value + ", consecutiveValueCount="
        + consecutiveValueCount + "]";
  }
}