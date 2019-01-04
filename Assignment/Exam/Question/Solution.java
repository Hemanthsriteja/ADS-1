class Solution{
  Solution() {
  }
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    Jury obj;
    while(scan.hasNextLine()) {
      String line  =  scan.nextLine();
      if (lines =="JC") {
        displayAll();
      }
      String[] tokens = line.split(",");
      obj = new Jury(tokens[0], tokens[1]);
    }
}
}