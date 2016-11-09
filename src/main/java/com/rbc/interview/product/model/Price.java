package com.rbc.interview.product.model;

/**
 * 
 * The class represents the unit or core price of the product. This class can be
 * further extended to add price code which will be linked to the product to
 * work out its price.
 * 
 * @author jshah
 *
 */
public class Price {
  /** The double value of the price. */
  private double price;

  /**
   * Constructs the price object.
   * 
   * @param price
   *          Price
   */
  public Price(final double price) {
	this.price = price;
  }

  /**
   * Gets the price.
   * 
   * @return double
   */
  public double getPrice() {
	return price;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	Price other = (Price) obj;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
	  return false;
	return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "Price [unitPrice=" + price + "]";
  }

}
