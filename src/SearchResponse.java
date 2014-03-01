/*This module searches the response and returns the result array*/

public class SearchResponse {

	private String statusCode;
	private ZappoBean[] results;

	public SearchResponse(String statusCode, ZappoBean[] results) {
		this.statusCode = statusCode;
		this.results = results;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public ZappoBean[] getResults() {
		
		return results;
	}
}