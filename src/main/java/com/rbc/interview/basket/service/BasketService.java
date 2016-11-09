package com.rbc.interview.basket.service;

import java.util.ArrayList;
import java.util.List;

import com.rbc.interview.basket.model.Basket;
import com.rbc.interview.basket.model.BasketItem;
import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.PricedProduct;
import com.rbc.interview.product.service.ProductPriceService;

/**
 * The class <code>BasketService</code> will be used by client to get
 * information about the basket items stored in the given basket. It also calls
 * the product service to price each item in the basket.
 * 
 * @author jshah
 *
 */
public final class BasketService {
  /** The reference of {@link ProductPriceService}. */
  private ProductPriceService productPriceService;

  /**
   * The method iterates through all basket items in the given basket, calls the
   * product pricing service to price the product as per unit price, quantity
   * and special discount if any. It then finds the total cost of of all items
   * in that basket.
   * 
   * @param basket
   *          Basket
   * @return double total cost of all basket items in the given basket.
   * @throws PriceException
   *           thrown if unit price is not set into the product
   * @see Basket
   */
  public double getBasketTotalCost(final Basket basket) throws PriceException {
	List<BasketItem> basketItems = basket.getBasketItems();
	List<Double> costs = new ArrayList<>();
	basketItems.forEach(basketItem -> {
	  PricedProduct pricedProduct = basketItem.getPricedProduct();
	  int quantity = basketItem.getProductQuantity();
	  double discountedCost = getDiscountedCost(pricedProduct, quantity);
	  costs.add(discountedCost);
	});
	return costs.stream().mapToDouble(totalCost -> totalCost.doubleValue()).sum();
  }

  /**
   * The method populates the String to display output of all basket items in
   * the Basket. For example, Product: Banana, Price: 1.5, Quantity: 5, Cost:
   * 7.5, Discount: 0.01, Discounted Price: 7.425
   * 
   * @param basket
   *          {@link Basket}
   * @return String
   * @throws PriceException
   *           thrown if failed to get the discounted cost of the product.
   */
  public String printBasket(final Basket basket) throws PriceException {
	basket.setTotalCost(getBasketTotalCost(basket));
	StringBuffer output = new StringBuffer();

	List<BasketItem> basketItems = basket.getBasketItems();
	output.append("\n").append("\n");
	output.append("===========BASKET INFORMATION STARTS===========");
	basketItems.forEach(basketItem -> {
	  PricedProduct p = basketItem.getPricedProduct();
	  int quantity = basketItem.getProductQuantity();
	  double unitPrice = p.getUnitPrice().getPrice();
	  double cost = unitPrice * quantity;
	  double discount = p.getSpecialOfferPrice().getDiscount() / 100;
	  try {
		output.append("\n");
		output.append("Product: ").append(p.getProduct().getDescription()).append(", Price: ").append(unitPrice)
			.append(", Quantity: ").append(quantity).append(", Cost: ").append(cost).append(", Discount: ")
			.append(discount).append(", Discounted Price: ").append(getDiscountedCost(p, quantity));
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	});

	output.append("\n").append("BASKET TOTAL COST: ").append(basket.getTotalCost());
	output.append("\n").append("\n").append("===========BASKET INFORMATION ENDS===========");
	return output.toString();

  }

  /**
   * Makes a call to the {@link ProdcutPriceService} to get the discounted price
   * of the given {@link PricedProduct}.
   * 
   * @param pricedProduct
   *          PricedProduct
   * @param quantity
   *          integer
   * @return double
   */
  private double getDiscountedCost(final PricedProduct pricedProduct, final int quantity) {
	double discountedCost = 0.0d;
	try {
	  discountedCost = productPriceService.getDiscountedCost(pricedProduct, quantity);
	} catch (Exception e) {
	  // TODO Auto-generated catch block
	  throwActualException(e);
	}
	return discountedCost;
  }

  /**
   * Wraps the specific exception in the Exception object and re throws it.
   * Required to be used within lamda expression.
   * 
   * @param exception
   *          Exception
   * @throws E
   *           type of Exception
   * @param <E>
   *          type of Exception
   */
  @SuppressWarnings("unchecked")
  private static <E extends Exception> void throwActualException(final Exception exception) throws E {
	throw (E) exception;
  }

  /**
   * Sets the ProductPriceService.
   * 
   * @param priceService
   *          ProductPriceService
   */
  public void setProductPriceService(final ProductPriceService priceService) {
	this.productPriceService = priceService;
  }
}
