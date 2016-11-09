package com.rbc.interview.product.model;

/**
 * The class <code>SpecialOfferPrice</code> holds the information about any
 * special discount to be offered on the product price. This class can be
 * further extended to have special offer code or special offer strategy to
 * price the product in a more advanced way.
 * 
 * @author jshah
 *
 */
public class SpecialOfferPrice {

  /**
   * The discount applied to the product, double.
   */
  private double discount;

  /**
   * Constructs the SpecialOfferPrice.
   * 
   * @param offer
   *          double discount applied to the product price
   */
  public SpecialOfferPrice(final double offer) {
	discount = offer;
  }

  /**
   * Gets the discount.
   * 
   * @return double
   */
  public double getDiscount() {
	return discount;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(discount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	SpecialOfferPrice other = (SpecialOfferPrice) obj;
	if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
	  return false;
	return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "SpecialOfferPrice [discount=" + discount + "]";
  }

}
