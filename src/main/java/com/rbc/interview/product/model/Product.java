package com.rbc.interview.product.model;

/**
 * The <code>Product</code> class holds the information about the product e.g.
 * id, description etc.
 * 
 * @author jshah
 *
 */
public final class Product {
  /** The unique product id. */
  private String id;
  /** The product description. */
  private String description;

  /**
   * Constructs the Product.
   * 
   * @param productId
   *          String product id
   * @param desc
   *          String description
   * @param pr
   *          Price price of this product
   * 
   * @see ProductType
   */
  public Product(final String productId, final String desc) {
	id = productId;
	description = desc;
  }

  /**
   * Gets the product id.
   * 
   * @return String
   */
  public String getId() {
	return id;
  }

  /**
   * Gets the product description.
   * 
   * @return String
   */
  public String getDescription() {
	return description;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
	return "Product [id=" + id + ", description=" + description + "]";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	Product other = (Product) obj;
	if (description == null) {
	  if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	  return false;
	if (id == null) {
	  if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	  return false;
	return true;
  }

}
