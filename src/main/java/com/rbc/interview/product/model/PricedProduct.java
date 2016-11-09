package com.rbc.interview.product.model;

import com.rbc.interview.basket.model.BasketItem;

/**
 * The class <code>PricedProduct</code> represents the product which is already
 * priced with unit price or discounted price. This will be used to add into
 * {@link BasketItem} to price the basket as a whole.
 * 
 * @author jshah
 *
 */
public class PricedProduct {
  /** The reference of {@link Product}. */
  private Product product;
  /**
   * The reference of {@link Price}, represents the unit price of the product,
   * must not be null.
   */
  private Price unitPrice;
  /**
   * The reference of {@link SpecialOfferPrice}, represents the discount in % on
   * the product unit price, can be null.
   */
  private SpecialOfferPrice specialOfferPrice;

  /**
   * Constructs the PricedProduct.
   * 
   * @param prd
   *          Product
   * @param unitPrice
   *          Price the unit price of the product, this must not be null
   *          otherwise service will fail to price the product
   * @param specialOfferPrice
   *          SpecialOfferPrice the discount applied to the product price
   */
  public PricedProduct(final Product prd, final Price unitPrice, final SpecialOfferPrice specialOfferPrice) {
	super();
	this.product = prd;
	this.unitPrice = unitPrice;
	this.specialOfferPrice = specialOfferPrice;
  }

  /**
   * Gets the reference of {@link Product}.
   * 
   * @return Product
   */
  public Product getProduct() {
	return product;
  }

  /**
   * Gets the reference of {@link Price}, represents the unit price of this
   * product.
   * 
   * @return Price
   */
  public Price getUnitPrice() {
	return unitPrice;
  }

  /**
   * Gets the reference of {@link SpecialOffer}, represents the discount applied
   * to this product price. May return null if no discount is offered.
   * 
   * @return SpecialOfferPrice
   */
  public SpecialOfferPrice getSpecialOfferPrice() {
	return specialOfferPrice;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "PricedProduct [product=" + product + ", unitPrice=" + unitPrice + ", specialOfferPrice=" + specialOfferPrice
		+ "]";
  }

}
