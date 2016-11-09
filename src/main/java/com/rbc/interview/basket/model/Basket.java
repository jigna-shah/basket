package com.rbc.interview.basket.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class <code>Basket</code> holds the list of {@link BasketItem}. The
 * basket will be used by client to show the total cost of all its basket items.
 * 
 * @author jshah
 *
 */
public final class Basket {
  /**
   * List of {@link BasketItem}.
   */
  private List<BasketItem> basketItems;
  /** Represents the total cost of all basket items in this basket. */
  private double totalCost;

  /**
   * Constructs Basket object.
   */
  public Basket() {
	basketItems = new ArrayList<>();
  }

  /**
   * The method which adds the BasketItem into this basket.
   * 
   * @param item
   *          BasketItem
   */
  public void addBasketItem(final BasketItem item) {
	basketItems.add(item);
  }

  /**
   * Gets the unmodifiable list of {@link BasketItem}.
   * 
   * @return List of BasketItem
   */
  public List<BasketItem> getBasketItems() {
	return Collections.unmodifiableList(basketItems);
  }

  /**
   * Gets the total cost of all basketItems in this basket. This will be
   * populated by the pricing service at the time of costing.
   * 
   * @return double
   */
  public double getTotalCost() {
	return totalCost;
  }

  /**
   * Sets the total cost of all basketItems in this basket. This will be
   * populated by the pricing service at the time of costing.
   * 
   * @param totalCst
   *          double
   */
  public void setTotalCost(final double totalCst) {
	this.totalCost = totalCst;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "Basket [basketItems=" + basketItems + ", totalCost=" + totalCost + "]";
  }

}
