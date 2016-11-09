package com.rbc.interview.product.dao;

import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.Price;
import com.rbc.interview.product.model.PricedProduct;

/**
 * The DataAcccessObject class of the Product to work out its price.
 * 
 * @author jshah
 *
 */
public interface ProductPriceDAO {
  /**
   * The method gets the unit price of this product.
   * 
   * @param product
   *          Product product
   * @return double the price of this product.
   * @throws PriceException
   *           if the unit price of this product is missing
   */
  Price getPrice(final PricedProduct product) throws PriceException;

}
