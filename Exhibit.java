/*
Modeled after code presented in tutorials by Dr. Nesbitt for Newcastle University CSC 8011.
 */
package csc8011;
/*
Constructor class for Exhibit
 */

public class Exhibit {
    private int exhibitID;
    private String description;
    private int yearAcquired;
    private double value;


    /**
     * Class Constructor.
     *This sets the item Exhibit. Exhibit items have four attributes: ID, description, the year of acquisition, and the estimated value.
     * @param exhibitID Integer, Exhibit ID
     * @param description String, Description of exhibit item
     * @param yearAcquired Integer, Year Item was Acquired by Museum
     * @param value Double, Value of exhibit item
     */
    public Exhibit(int exhibitID, String description, int yearAcquired, double value) {
        this.exhibitID = exhibitID;
        this.description = description;
        this.yearAcquired = yearAcquired;
        this.value = value;
    }
    /**
     * This method returns the exhibit ID integer to the main.
     * @return ExhibitID, Integer exhibit item ID
     */
    public int getExhibitID() {
        return exhibitID;
    }
    /**
     *  This method allows the user to set a value for the exhibitID.
     *  @param exhibitID Integer, exhibit item ID
     */
    public void setExhibitID(int exhibitID) {
        this.exhibitID = exhibitID;
    }
    /**
     *  This method returns a description of the exhibit item to the main.
     *  @return description String, Description of exhibit item
    */
    public String getDescription() {
        return description;
    }
    /**
     *  This method allows the user to set a description for the exhibit item.
     *  @param description String, Description of exhibit item
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *  This method returns the year the exhibit item was acquired to the main.
     *  @return yearAcquired, year exhibit item was acquired by the museum
    */
    public int getYearAcquired() {
        return yearAcquired;
    }
    /**
     *  This method sets a year of acquisition for the exhibit item.
     *  @param yearAcquired Integer, Year item was acquired by museum
     */
    public void setYearAcquired(int yearAcquired) {
        this.yearAcquired = yearAcquired;
    }
    /**
     * This method returns the value of the exhibit item to the main.
     * @return Double, Value of exhibit item
     */
    public double getValue() {
        return value;
    }
    /**
     *  This method allows the user to set a value for the exhibitID.
     *  @param value Double, Value of exhibit item
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     *  This method overrides the built-in Java method toString and tells it how to print out the exhibit items.
     *  @return String, String of exhibit, exhibitID, description, year acquired, and value of exhibit items.
     */
    @Override
    public String toString() {
        return "Exhibit{" +
                "exhibitID=" + exhibitID +
                ", description='" + description + '\'' +
                ", yearAcquired=" + yearAcquired +
                ", value=" + value +
                '}';
    }
}