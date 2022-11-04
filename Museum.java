/*
Modeled after code presented in tutorials by Dr. Nesbitt for Newcastle University CSC 8011.
 */
package csc8011;
import java.util.ArrayList;

/*
This is the Constructor class for the Museum.
 */
public class Museum {
    private ArrayList<Exhibit> exhibitList = new ArrayList<>();
    private String museumName;

    /**
     * museumName String, default name for museum
     */
    public Museum() {

        museumName="Isabella Stewart Gardner Museum";
    }

    /**
    This method returns the museum name to the main method.
     * @return museumName String, name of museum
     */
    public String getMuseumName() {
        return museumName;
    }
    /**
     * This method allows the user to set the museum name (through an option in the main method).
     * @param museumName String, name of museum
     */
    public void setMuseumName(String museumName) {

        this.museumName=museumName;
    }
    /**
     *  This method adds an exhibit item to the Exhibit array list and returns the amended array list to the main method.
     * @param e ArrayList item
     * @return exhibitList ArrayList, list of exhibit items
     */
    public java.util.ArrayList<Exhibit> addExhibit(Exhibit e) {
        exhibitList.add(e);
        return exhibitList;
    }
    /**
     *  This method allows access to the list of exhibit items.
     * @return exhibitList ArrayList, list of exhibit items
     */
    public ArrayList<Exhibit> getExhibitList() {
        return exhibitList;
    }
    /**
     *  This method loops through all items in the array list exhibit list. It looks for the year in each item and, if the item it's looking at is older than
     *  the stored value, replaces the stored value with that item. At the end of the list, the stored value is equivalent to the oldest item.
     *  The method then returns this exhibit item to the main method.
     * @return ArrayList item, exhibit item in arraylist
     */
    public Exhibit getOldestItem(){
        Exhibit oldest = exhibitList.get(0);
        for (Exhibit e : exhibitList) {
            if (e.getYearAcquired() < oldest.getYearAcquired()) {
                oldest = e;
            }
        }
        return oldest;
    }
    /**
     *  This method loops through all items in the array list exhibit list. It looks for the value in each item and, if the item it's looking at is more expensive
     *  than the stored value, replaces the stored value with that item. At the end of the list, the stored value is equivalent to the most expensive item.
     *  The method then returns this exhibit item to the main method.
     *  @return ArrayList item, exhibit item in arraylist
     */
    public Exhibit getHighestValue() {
        Exhibit expensive = exhibitList.get(0);
        for (Exhibit e : exhibitList) {
            if (expensive.getValue() < e.getValue()) {
                expensive = e;
            }
        }
        return expensive;
    }
    /**
     *  This method sets a running total by looping through all items in the array list exhibit list and getting the value of the item. It adds the item's
     *  value to the running total. After exhausting all the items in the list, it finds the average by dividing the running total by the number of entries
     *  (i.e., the size of the array list.) The method then returns this value to the main method.
     * @return average Double, double average value of all items in exhibit
     */
    public double getAverage() {
        double runningTotal = 0;
        for (Exhibit e : exhibitList) {
            runningTotal = runningTotal + e.getValue();
        }
        double average = runningTotal / exhibitList.size();
        return average;
    }
}
