package com.rbc.interview.product.service;

import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.PricedProduct;

/**
 * The interface <code>ProductPriceService</code> is responsible to price the
 * product by using different pricing strategy.
 * 
 * @author jshah
 *
 */
public interface ProductPriceService {

  /**
   * Calculates the discount applied to the product's actual cost and returns
   * the discounted price.
   * 
   * @param pricedProduct
   *          PricedProduct product which holds discount and unit price already
   * @param quantity
   *          integer the product quantity
   * @return double the discounted price
   * @throws PriceException
   *           thrown if failed to price the product
   */
  public double getDiscountedCost(final PricedProduct pricedProduct, final int quantity) throws PriceException;

}
