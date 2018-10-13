import java.util.*;
/**.
 * @author Hemanth Sriteja
 */
/**.
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
	String stockName;
	int stockFrequency;
	/**.
	 * Constructs the object.
	 *
	 * @param      stockName       The stock name
	 * @param      stockFrequency  The stock frequency
	 */
	Stock(String stockName, int stockFrequency) {
		this.stockName = stockName;
		this.stockFrequency = stockFrequency;
	}
	/**.
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.stockName;
	}
	/**.
	 * Gets the frequency.
	 *
	 * @return     The frequency.
	 */
	public int getFrequency() {
		return this.stockFrequency;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.stockName + " " + this.stockFrequency;
	}
	/**.
	 * using compareTo here
	 *
	 * @param      that  The that
	 *
	 * @return     1, -1 or 0 based on the below mentioned criteria.
	 */
	public int compareTo(final Stock that) {
		if (this.stockFrequency > that.getFrequency()) {
				return 1;
		}
		if (this.stockFrequency < that.getFrequency()) {
				return -1;
		}
		if (this.stockName.compareTo(that.getName()) > 0) {
				return 1;
		}
		if (this.stockName.compareTo(that.getName()) < 0) {
				return -1;
		} else {
			return 0;
		}
	}
}