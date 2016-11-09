package com.rbc.interview.product.dao;

import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.Price;
import com.rbc.interview.product.model.PricedProduct;

/**
 * The <code>StaticProductPriceDAO</code> class is the concrete implementation
 * of an interface {@link ProductPriceDAO}. The class gives information about
 * the product price e.g. special offer price or normal price etc.
 * 
 * @author jshah
 *
 */
public final class StaticProductPriceDAO implements ProductPriceDAO {

  /**
   * {@inheritDoc}
   */
  @Override
  public Price getPrice(final PricedProduct pricedProduct) throws PriceException {
	Price price = pricedProduct.getUnitPrice();
	if (price == null) {
	  throw new PriceException("Cannot find unit price for product - " + pricedProduct.getProduct().getDescription());
	}
	return price;
  }

}
