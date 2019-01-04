public class Jury implements Comparable<Jury> {
    private Integer regno;
    private Integer sectionid;
    /**
     * Constructs the object.
     */
    public Jury() {

    }
    public Jury(Integer sid, Integer rid) {
        this.regno = rid;
        this.sectionid = sid;
    }
    public Integer getregno() {
        return this.regno;
    }
    public Integer getsecid() {
        return this.sectionid;
    }
    /**
     * Checks the various attributes and returns -1 or 0 or 1 accordingly.
     *
     * @param      that  The that
     *
     * @return     -1 or 0 or 1
     */
     public int compareTo(final Jury s1, final Jury s2) {
        if (s1.getsecid() < s2.getsecid()) {
            return  -1;
        } else if (s1.getsecid() > s2.getsecid()) {
            return 1;
        } else if (s1.getsecid() == s2.getsecid()) {
            if(s1.getregno() < s2.getregno()) {
              return -1;
            } else {
              return 1;
            }
        }
        return 0;
 }
 // public void displayAll() {
 //        for (int i = 0; i < a.size(); i++) {
 //          System.out.println(a.get(i).getsecid() + "," + a.get(i).getregno());
 //        }
 //        System.out.println();
 //    }
}