
/*This module provides the attributes to the items and consists of some setter and getter methods*/

public class ZappoBean {

	private String productId, brandName, productName, thumbnailImageUrl, originalPrice, price, percentOff, productUrl,defaultImageUrl;
	

	public ZappoBean(String productName, String percentOff, String productId, String brandName) {
		this.productName = productName;
		this.percentOff = percentOff;
		this.productId = productId;
		this.brandName = brandName;
	}

	public ZappoBean() {
		this.productId = "";
		this.productName = "";
		this.brandName = "";
		this.originalPrice = "";
		this.percentOff = "0%";
		this.price = "";
		this.productUrl = "";
	}
	
	public String getProductName() {
		return productName;
	}

	
	// Percent Off
	public String getPercentOff() {
		return percentOff;
	}

	

	
	
		// Thumbnail Image URL
	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}

		// Product ID
	public String getProductId() {
		return productId;
	}

	
	
	
	// Brand Name
	public String getBrandName() {
		return brandName;
	}

	
	// Price
	public String getPrice() {
		return price;
	}

	
	// Original Price
	public String getOriginalPrice() {
		return originalPrice;
	}

	
	// Product URL
	public String getProductUrl() {
		return productUrl;
	}
	
	public String getDefaultImageUrl() {
		return defaultImageUrl;
	}
	
	public void setDefaultImageUrl(String defaultImageUrl) {
		this.defaultImageUrl = defaultImageUrl;
	}

	
	public String toString() {
		return "Brand Name: "+brandName + "\nProduct Name:  " + productName + "\nPrice: " + price + "\nDiscount: " + percentOff + " off\nProduct URL: " + productUrl;
	}
}
