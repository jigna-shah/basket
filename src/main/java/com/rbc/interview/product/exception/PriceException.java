package com.rbc.interview.product.exception;

/**
 * The exception to be used by product services and product DAO when product
 * pricing functionality is failed.
 * 
 * @author jshah
 *
 */
public final class PriceException extends Exception {

  /**
   * Constructs a PriceException object.
   * 
   * @param message
   *          String the message to pass when exception is created
   */
  public PriceException(final String message) {
	super(message);
  }

}
