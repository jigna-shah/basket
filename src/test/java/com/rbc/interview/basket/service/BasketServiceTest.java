package com.rbc.interview.basket.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rbc.interview.basket.model.Basket;
import com.rbc.interview.basket.model.BasketItem;
import com.rbc.interview.product.dao.StaticProductPriceDAO;
import com.rbc.interview.product.exception.PriceException;
import com.rbc.interview.product.model.Price;
import com.rbc.interview.product.model.PricedProduct;
import com.rbc.interview.product.model.Product;
import com.rbc.interview.product.model.SpecialOfferPrice;
import com.rbc.interview.product.service.SimpleProductPriceService;

/**
 * The test class to test functionalities of {@link BasketService}.
 * 
 * @author jshah
 *
 */
public class BasketServiceTest {
  /** The ExpectedException. */
  @Rule
  public final ExpectedException exception = ExpectedException.none();
  private static BasketService basketService;

  /**
   * The method is used to create instances before the entire test fixtures.
   */
  @BeforeClass
  public static void setUp() {
	basketService = new BasketService();
	basketService.setProductPriceService(new SimpleProductPriceService(new StaticProductPriceDAO()));
  }

  /**
   * Nullify the instance of ReviewerService after all tests are executed.
   */
  @AfterClass
  public static void tearDown() {

  }

  /**
   * Tests the {@link BasketService#getBasketTotalCost(Basket)} for well
   * populated products. Tests that the basket is priced correctly based on
   * product unit price, quantity and its discount if any.
   */
  @Test
  public void basketTotalCostForValidProduct() {
	try {
	  Basket basket = setupBasket();
	  double expected = 33.975;
	  double actual = basketService.getBasketTotalCost(basket);
	  Assert.assertEquals("Expected total cost of basket", expected, actual, 0.0d);
	} catch (PriceException e) {
	  Assert.fail("Error was not expected but got :" + e.getMessage());
	}
  }

  /**
   * Tests the {@link BasketService#getBasketTotalCost(Basket)} for invalid
   * product. Invalid product means the product which does not have a unit price
   * assigned. The method tests that the expected exception is thrown.
   * 
   * @throws PriceException
   *           expected exception
   */
  @Test
  public void basketTotalCostForInvalidProduct() throws PriceException {
	Product dummy = new Product("P1", "Dummy");
	PricedProduct pricedDummy = new PricedProduct(dummy, null, null);
	BasketItem dummies = new BasketItem(pricedDummy, 5);
	Basket basket = new Basket();
	basket.addBasketItem(dummies);

	exception.expect(PriceException.class);
	exception.expectMessage("Cannot find unit price for product - Dummy");
	basketService.getBasketTotalCost(basket);
  }

  /**
   * The method prints the information about all basket items. The method fails
   * if exception occurs.
   */
  @Test
  public void printBasket() {
	Basket basket = setupBasket();
	try {
	  System.out.println(basketService.printBasket(basket));
	} catch (PriceException e) {
	  // TODO Auto-generated catch block
	  Assert.fail("Expected Basket to be printed but got error " + e.getMessage());
	}
  }

  /**
   * Sets up the test data.
   * 
   * @return Basket
   */
  private Basket setupBasket() {
	Product banana = new Product("P1", "Banana");
	Product orange = new Product("P2", "Orange");
	Product peach = new Product("P3", "Peach");
	Product lemon = new Product("P4", "Lemon");
	Product apple = new Product("P5", "Apple");

	PricedProduct pricedBanana = new PricedProduct(banana, new Price(1.50d), new SpecialOfferPrice(1.0d));
	PricedProduct pricedOrange = new PricedProduct(orange, new Price(1.75d), new SpecialOfferPrice(0.0d));
	PricedProduct pricedPeach = new PricedProduct(peach, new Price(2.50d), new SpecialOfferPrice(2.0d));
	PricedProduct pricedLemon = new PricedProduct(lemon, new Price(0.50d), new SpecialOfferPrice(0.0d));
	PricedProduct pricedApple = new PricedProduct(apple, new Price(2.00d), new SpecialOfferPrice(5.0d));

	BasketItem bananas = new BasketItem(pricedBanana, 5);
	BasketItem oranges = new BasketItem(pricedOrange, 3);
	BasketItem peaches = new BasketItem(pricedPeach, 2);
	BasketItem apples = new BasketItem(pricedApple, 6);
	BasketItem lemons = new BasketItem(pricedLemon, 10);

	Basket basket = new Basket();
	basket.addBasketItem(bananas);
	basket.addBasketItem(oranges);
	basket.addBasketItem(peaches);
	basket.addBasketItem(apples);
	basket.addBasketItem(lemons);

	return basket;
  }
}
