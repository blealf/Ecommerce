/**
 * A name has a first name and a family name.
 * There is an option to produce a full name by combining these.
 * 
 * @author Luke
 */
public class Name {

	//Fields
	private String firstName; 
	private String familyName;

	
	//Constructors
	/**Default Constructor. Initialises the firstName and
	 * familyName to an empty string.
	 */
	public Name() {
		firstName = "";
		familyName = "";
	}

	/**Initialises the firstName and familyName to the 
	 * values provided
	 * @param firstName The value for the firstName to be used.
	 * @param familyName The value for the familyName to be used.
	 */
	public Name(String firstName, String familyName) {
		this.firstName = firstName;
		this.familyName = familyName;
	}

	
	//Methods
	/**Sets the firstName to the value provided
	 * @param firstName The value to set the firstName to.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**Sets the familyName to the value provided
	 * @param familyName The value to set the familyName to.
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**Returns the firstName
	 * @return The firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**Returns the familyName
	 * @return The familyNmame
	 */
	public String getFamilyName() {
		return familyName;
	}
	
	/**Returns the firstName and familyNames in this order
	 * @return The firstName and familyNames in this order
	 */
	public String getFullName() {
		return firstName + " " + familyName;
	}
	
	/**Returns a textual representation of the Name class
	 * @return Returns a textual representation of the Name class
	 */
	@Override
	public String toString() {
		return "Name:[firstName=" + firstName + ", familyName=" + familyName + "]";
	}
	
	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		// test exceptional cases, i.e. obj is a Name, and not null
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Name other = (Name) obj; // cast to a Name object

		// compare first & family names using the String .equals()
		return this.familyName.equals(other.familyName)
			&& this.firstName.equals(other.firstName);
	}

}
