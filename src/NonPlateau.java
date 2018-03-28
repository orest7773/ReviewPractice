class NonPlateau implements Plateau {
  private int value;
  private int startIndex;
  public NonPlateau(int startIndex, int value) {
    this.startIndex = startIndex;
    this.value = value;
  }

  @Override
  public int compareTo(Plateau o) {
    return o.compareCountTo(-1); // non plataeus are always shorter
  }
  @Override
  public Plateau appendNextValue(int nextValue) {
    startIndex++;
    if (this.value < nextValue) // new plateau might start here
      return new RealPlateau(startIndex, nextValue);
    this.value = nextValue;
    return this;
  }
  @Override
  public int compareCountTo(int otherConsecutiveValueCount) {
    return otherConsecutiveValueCount + 1; // reverse logic
  }
  @Override
  public String toString() {
    return "NonPlataeu";
  }
}