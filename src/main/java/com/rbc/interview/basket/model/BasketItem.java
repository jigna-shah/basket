package com.rbc.interview.basket.model;

import com.rbc.interview.product.model.PricedProduct;
import com.rbc.interview.product.model.Product;

/**
 * The <code>BasketItem</code> to be added in the Basket. The class holds the
 * Product which is alredy priced and its quantity.
 * 
 * @author jshah
 *
 */
public final class BasketItem {
  /** The reference of {@link Product}. */
  private PricedProduct pricedProduct;
  /** The product quantity. */
  private int productQuantity;

  /**
   * Constructs the BasketItem.
   * 
   * @param prd
   *          the reference of {@link Product}
   * @param prdQuantity
   *          integer product quantity
   */
  public BasketItem(final PricedProduct prd, final int prdQuantity) {
	this.pricedProduct = prd;
	this.productQuantity = prdQuantity;
  }

  /**
   * Gets the {@link Product}.
   * 
   * @return reference of Product
   */
  public PricedProduct getPricedProduct() {
	return pricedProduct;
  }

  /**
   * Gets the product quantity.
   * 
   * @return integer
   */
  public int getProductQuantity() {
	return productQuantity;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((pricedProduct == null) ? 0 : pricedProduct.hashCode());
	result = prime * result + productQuantity;
	return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
	if (this == obj) {
	  return true;
	}
	if (obj == null) {
	  return false;
	}
	if (getClass() != obj.getClass()) {
	  return false;
	}
	BasketItem other = (BasketItem) obj;
	if (pricedProduct == null) {
	  if (other.pricedProduct != null) {
		return false;
	  }
	} else if (!pricedProduct.equals(other.pricedProduct)) {
	  return false;
	}
	if (productQuantity != other.productQuantity) {
	  return false;
	}
	return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "BasketItem [product=" + pricedProduct + ", productQuantity=" + productQuantity + "]";
  }
}
