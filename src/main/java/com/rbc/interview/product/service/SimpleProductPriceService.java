package com.rbc.interview.product.service;

import com.rbc.interview.product.dao.ProductPriceDAO;
import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.Price;
import com.rbc.interview.product.model.PricedProduct;
import com.rbc.interview.product.model.SpecialOfferPrice;

/**
 * The class concrete class <code>SimpleProductPriceService</code> implements
 * the interface {@link ProductPriceService} and override pricing
 * functionalities.
 * 
 * @author jshah
 *
 */
public class SimpleProductPriceService implements ProductPriceService {
  /** The reference of {@link ProductPriceDAO} . */
  private ProductPriceDAO productPriceDAO;

  /**
   * Constructs SimpleProductPriceService.
   * 
   * @param prdPriceDAO
   *          ProductPriceDAO
   */
  public SimpleProductPriceService(final ProductPriceDAO prdPriceDAO) {
	this.productPriceDAO = prdPriceDAO;
  }

  /**
   * The method gets the unit price of the product and calculates the discounted
   * price.
   * 
   * @param pricedProduct
   *          PricedProduct has unit and discount price
   * @param quantity
   *          number of items of this product
   * @return double discounted cost
   * @throws PriceException
   *           thrown if product does not have any unit price assigned
   */
  public double getDiscountedCost(final PricedProduct pricedProduct, final int quantity) throws PriceException {
	Price price = productPriceDAO.getPrice(pricedProduct);
	SpecialOfferPrice specialOfferPrice = pricedProduct.getSpecialOfferPrice();
	double productCost;
	double unitPrice = price.getPrice();
	double unitCost = unitPrice * quantity;
	if (specialOfferPrice != null) {
	  double discount = specialOfferPrice.getDiscount();
	  productCost = unitCost - (unitCost * (discount / 100));
	} else {
	  productCost = unitCost;
	}
	return productCost;
  }

}
